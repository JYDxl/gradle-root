package org.github.web.service;

import org.github.base.model.bo.ItemCommentBO;
import org.github.base.model.bo.ItemSearchBO;
import org.github.base.model.vo.ItemCommentCountsVO;
import org.github.base.model.vo.ItemCommentVO;
import org.github.base.model.vo.ItemSearchVO;
import org.github.spring.restful.Returnable;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface IItemService {
  ItemCommentCountsVO queryCommentCounts(String itemId);

  Returnable queryItemById(String id);

  Returnable queryItemImgListById(String id);

  Returnable queryItemParamById(String id);

  Returnable queryItemSpecListById(String id);

  IPage<ItemCommentVO> queryPagedComments(ItemCommentBO bo);

  IPage<ItemSearchVO> search(ItemSearchBO bo);
}
