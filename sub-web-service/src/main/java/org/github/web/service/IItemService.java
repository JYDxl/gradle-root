package org.github.web.service;

import org.github.base.IPage;
import org.github.web.model.bo.ItemCommentBO;
import org.github.web.model.bo.ItemSearchBO;
import org.github.web.model.bo.ItemSearchByCatBO;
import org.github.web.model.vo.ItemCommentCountsVO;
import org.github.web.model.vo.ItemCommentVO;
import org.github.web.model.vo.ItemSearchVO;
import org.github.spring.restful.Returnable;

public interface IItemService {
  IPage<ItemSearchVO> catItems(ItemSearchByCatBO bo);

  ItemCommentCountsVO queryCommentCounts(String itemId);

  Returnable queryItemById(String id);

  Returnable queryItemImgListById(String id);

  Returnable queryItemParamById(String id);

  Returnable queryItemSpecListById(String id);

  IPage<ItemCommentVO> queryPagedComments(ItemCommentBO bo);

  IPage<ItemSearchVO> search(ItemSearchBO bo);
}
