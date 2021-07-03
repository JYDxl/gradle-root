package org.github.leadnews.behavior.dto;

import java.util.List;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import lombok.*;
import org.github.base.IParam;
import org.github.mysql.leadnews.base.entity.ApBehaviorEntryEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SaveBehaviorBO extends ApBehaviorEntryEntity implements IParam {
  @Nullable
  private Long       equipmentId;
  @NotNull
  @Size(min = 1)
  private List<Long> articleIdList;

  @Null
  @Override
  public Long getId() {
    return super.getId();
  }

  @NotNull
  @Size(max = 1)
  @Override
  public Integer getType() {
    return super.getType();
  }
}
