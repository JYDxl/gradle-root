package org.github.base.model.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.github.base.IModel;
import org.github.base.entity.ItemsEntity;
import org.github.base.entity.ItemsImgEntity;
import org.github.base.entity.ItemsParamEntity;
import org.github.base.entity.ItemsSpecEntity;

@AllArgsConstructor
@Data
public class ItemInfoVO implements IModel {
  private ItemsEntity item;

  private List<ItemsImgEntity> itemImgList;

  private List<ItemsSpecEntity> itemSpecList;

  private ItemsParamEntity itemParams;
}
