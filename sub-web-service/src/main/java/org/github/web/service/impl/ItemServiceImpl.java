package org.github.web.service.impl;

import java.util.List;
import lombok.extern.slf4j.*;
import lombok.*;
import org.github.base.IPage;
import org.github.base.Page;
import org.github.base.entity.ItemsCommentsEntity;
import org.github.base.entity.ItemsEntity;
import org.github.base.entity.ItemsImgEntity;
import org.github.base.entity.ItemsParamEntity;
import org.github.base.entity.ItemsSpecEntity;
import org.github.web.model.bo.ItemCommentBO;
import org.github.web.model.bo.ItemSearchBO;
import org.github.web.model.bo.ItemSearchByCatBO;
import org.github.web.model.vo.ItemCommentCountsVO;
import org.github.web.model.vo.ItemCommentVO;
import org.github.web.model.vo.ItemInfoVO;
import org.github.web.model.vo.ItemSearchVO;
import org.github.base.service.IItemsCommentsService;
import org.github.base.service.IItemsImgService;
import org.github.base.service.IItemsParamService;
import org.github.base.service.IItemsService;
import org.github.base.service.IItemsSpecService;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONArrayReturn;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.web.mapper.IItemMapper;
import org.github.web.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
@Slf4j
public class ItemServiceImpl implements IItemService {
  @Autowired
  private IItemsService         itemsService;
  @Autowired
  private IItemsImgService      itemsImgService;
  @Autowired
  private IItemsSpecService     itemsSpecService;
  @Autowired
  private IItemsParamService    itemsParamService;
  @Autowired
  private IItemsCommentsService itemsCommentsService;
  @Autowired
  private IItemMapper           itemMapper;

  @Override
  public IPage<ItemSearchVO> catItems(ItemSearchByCatBO bo) {
    val page = new Page<ItemSearchVO>(bo);
    itemMapper.catItems(bo, page);
    return page;
  }

  @Override
  public ItemCommentCountsVO queryCommentCounts(String itemId) {
    val goodCount   = queryItemsComments(itemId, 1);
    val normalCount = queryItemsComments(itemId, 2);
    val badCount    = queryItemsComments(itemId, 3);
    return new ItemCommentCountsVO(goodCount + normalCount + badCount, goodCount, normalCount, badCount);
  }

  @Override
  public Returnable queryItemById(String id) {
    ItemsEntity entity = itemsService.getById(id);

    LambdaQueryWrapper<ItemsImgEntity> itemsQuery = Wrappers.lambdaQuery();
    itemsQuery.eq(ItemsImgEntity::getItemId, id);
    List<ItemsImgEntity> itemsImgList = itemsImgService.list(itemsQuery);

    LambdaQueryWrapper<ItemsParamEntity> itemsParamQuery = Wrappers.lambdaQuery();
    itemsParamQuery.eq(ItemsParamEntity::getItemId, id);
    ItemsParamEntity itemsParam = itemsParamService.getOne(itemsParamQuery, true);

    LambdaQueryWrapper<ItemsSpecEntity> itemsSpecQuery = Wrappers.lambdaQuery();
    itemsSpecQuery.eq(ItemsSpecEntity::getItemId, id);
    List<ItemsSpecEntity> itemsSpecList = itemsSpecService.list(itemsSpecQuery);

    ItemInfoVO vo = new ItemInfoVO(entity, itemsImgList, itemsSpecList, itemsParam);

    return JSONDataReturn.of(vo);
  }

  @Override
  public Returnable queryItemImgListById(String id) {
    LambdaQueryWrapper<ItemsImgEntity> query = Wrappers.lambdaQuery();
    query.eq(ItemsImgEntity::getItemId, id);
    List<ItemsImgEntity> list = itemsImgService.list(query);
    return JSONArrayReturn.of(list);
  }

  @Override
  public Returnable queryItemParamById(String id) {
    LambdaQueryWrapper<ItemsParamEntity> query = Wrappers.lambdaQuery();
    query.eq(ItemsParamEntity::getItemId, id);
    ItemsParamEntity entity = itemsParamService.getOne(query, true);
    return JSONDataReturn.of(entity);
  }

  @Override
  public Returnable queryItemSpecListById(String id) {
    LambdaQueryWrapper<ItemsSpecEntity> query = Wrappers.lambdaQuery();
    query.eq(ItemsSpecEntity::getItemId, id);
    List<ItemsSpecEntity> list = itemsSpecService.list(query);
    return JSONArrayReturn.of(list);
  }

  @Override
  public IPage<ItemCommentVO> queryPagedComments(ItemCommentBO bo) {
    val page = new Page<ItemCommentVO>(bo);
    itemMapper.queryPagedComments(bo, page);
    return page;
  }

  @Override
  public IPage<ItemSearchVO> search(ItemSearchBO bo) {
    val page = new Page<ItemSearchVO>(bo);
    itemMapper.search(bo, page);
    return page;
  }

  private int queryItemsComments(String itemId, Integer commentLevel) {
    val query = itemsCommentsService.lambdaQuery();
    query.eq(ItemsCommentsEntity::getItemId, itemId);
    if (commentLevel != null) query.eq(ItemsCommentsEntity::getCommentLevel, commentLevel);
    return query.count();
  }
}
