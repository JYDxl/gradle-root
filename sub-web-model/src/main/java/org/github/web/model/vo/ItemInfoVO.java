package org.github.web.model.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.github.base.IParam;
import org.github.base.entity.ItemsEntity;
import org.github.base.entity.ItemsImgEntity;
import org.github.base.entity.ItemsParamEntity;
import org.github.base.entity.ItemsSpecEntity;

@AllArgsConstructor
@Data
public class ItemInfoVO implements IParam {
  private ItemsEntity item;

  private List<ItemsImgEntity> itemImgList;

  private List<ItemsSpecEntity> itemSpecList;

  private ItemsParamEntity itemParams;
}
