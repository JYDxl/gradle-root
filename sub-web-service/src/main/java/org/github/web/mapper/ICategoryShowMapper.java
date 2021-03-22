package org.github.web.mapper;

import java.util.List;
import org.github.base.model.vo.CategoryVO;
import org.github.base.model.vo.NewItemsVO;
import org.github.mybatis.MyBatisMapper;
import org.apache.ibatis.annotations.Param;

@MyBatisMapper
public interface ICategoryShowMapper {
  List<NewItemsVO> getSixNewItemsLazy(@Param("id") int rootCatId);

  List<CategoryVO> queryAllSubCat(@Param("id") int rootCatId);
}
