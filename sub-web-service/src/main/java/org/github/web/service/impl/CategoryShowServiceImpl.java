package org.github.web.service.impl;

import java.util.List;
import lombok.extern.slf4j.*;
import org.github.base.entity.CategoryEntity;
import org.github.base.model.po.NoticePO;
import org.github.base.model.vo.CategoryVO;
import org.github.base.model.vo.NewItemsVO;
import org.github.base.service.ICategoryService;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONArrayReturn;
import org.github.web.mapper.ICategoryShowMapper;
import org.github.web.service.ICategoryShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import static org.springframework.transaction.annotation.Propagation.*;

@Service
@Slf4j
public class CategoryShowServiceImpl implements ICategoryShowService {
  @Autowired
  private ICategoryService    categoryService;
  @Autowired
  private ICategoryShowMapper categoryShowMapper;

  @Override
  public Returnable getSixNewItemsLazy(int rootCatId) {
    List<NewItemsVO> list = categoryShowMapper.getSixNewItemsLazy(rootCatId);
    return JSONArrayReturn.of(list);
  }

  @Override
  public Returnable notice(NoticePO po) {
    return Returnable.nil();
  }

  @Transactional(propagation = SUPPORTS, readOnly = true)
  @Override
  public Returnable queryAllRootCat() {
    LambdaQueryWrapper<CategoryEntity> query = Wrappers.lambdaQuery();
    query
      .eq(CategoryEntity::getType, 1);
    List<CategoryEntity> list = categoryService.list(query);
    return JSONArrayReturn.of(list);
  }

  @Transactional(propagation = SUPPORTS, readOnly = true)
  @Override
  public Returnable queryAllSubCat(int rootCatId) {
    List<CategoryVO> list = categoryShowMapper.queryAllSubCat(rootCatId);
    return JSONArrayReturn.of(list);
  }
}
