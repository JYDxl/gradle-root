package org.github.web.mapper;

import org.github.base.IPage;
import org.github.web.model.bo.ItemCommentBO;
import org.github.web.model.bo.ItemSearchBO;
import org.github.web.model.bo.ItemSearchByCatBO;
import org.github.web.model.vo.ItemCommentVO;
import org.github.web.model.vo.ItemSearchVO;
import org.github.mybatis.MyBatisMapper;

@MyBatisMapper
public interface IItemMapper {
  IPage<ItemSearchVO> catItems(ItemSearchByCatBO bo, IPage<ItemSearchVO> page);

  IPage<ItemCommentVO> queryPagedComments(ItemCommentBO bo, IPage<ItemCommentVO> page);

  IPage<ItemSearchVO> search(ItemSearchBO bo, IPage<ItemSearchVO> page);
}
