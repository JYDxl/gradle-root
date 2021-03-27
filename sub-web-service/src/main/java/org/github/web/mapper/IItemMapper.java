package org.github.web.mapper;

import org.github.base.model.bo.ItemCommentBO;
import org.github.base.model.bo.ItemSearchBO;
import org.github.base.model.bo.ItemSearchByCatBO;
import org.github.base.model.vo.ItemCommentVO;
import org.github.base.model.vo.ItemSearchVO;
import org.github.mybatis.MyBatisMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

@MyBatisMapper
public interface IItemMapper {
  IPage<ItemSearchVO> catItems(ItemSearchByCatBO bo, IPage<ItemSearchVO> page);

  IPage<ItemCommentVO> queryPagedComments(ItemCommentBO bo, IPage<ItemCommentVO> page);

  IPage<ItemSearchVO> search(ItemSearchBO bo, IPage<ItemSearchVO> page);
}
