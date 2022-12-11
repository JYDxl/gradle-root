package org.github.core.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;
import lombok.val;
import static cn.hutool.core.lang.Validator.isGeneral;
import static cn.hutool.core.text.CharSequenceUtil.toUnderlineCase;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.asc;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.desc;

@ApiModel("排序参数")
@Data
public class Sort implements IBo {
  @ApiModelProperty(value = "使用下划线模式", example = "true")
  private boolean underLine = true;

  @ApiModelProperty(value = "排序字段")
  private @Nullable String sortName;

  @ApiModelProperty(value = "排序方式", example = "asc")
  private @NonNull String sortOrder = "asc";

  @Override
  public String toString() {
    return get();
  }

  public void setSortName(@Nullable String sortName) {
    if (!isGeneral(sortName)) return;
    this.sortName = sortName;
  }

  public void setSortOrder(@NonNull String sortOrder) {
    val order = sortOrder.toLowerCase();
    if (!(order.equals("asc") || order.equals("desc"))) return;
    this.sortOrder = order;
  }

  protected @Nullable OrderItem sort() {
    if (sortName == null) return null;
    val order = underLine ? toUnderlineCase(sortName) : sortName;
    return sortOrder.equals("asc") ? asc(order) : desc(order);
  }
}
