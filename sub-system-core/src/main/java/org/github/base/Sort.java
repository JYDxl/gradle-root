package org.github.base;

import javax.annotation.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.experimental.Accessors;
import static cn.hutool.core.lang.Validator.*;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.*;

@Accessors(chain = true)
@Data
@ApiModel(value = "Sort对象", description = "排序参数")
public class Sort {
  @ApiModelProperty(value = "是否使用下划线模式", example = "true")
  private boolean underLine = true;

  @ApiModelProperty(value = "排序属性", example = " ")
  private @Nullable String sortName;

  @ApiModelProperty(value = "排序方式", example = "asc")
  private @NonNull String sortOrder = "asc";

  public void setSortName(@Nullable String sortName) {
    if (!isGeneral(sortName)) return;
    this.sortName = sortName;
  }

  public void setSortOrder(@NonNull String sortOrder) {
    val order = sortOrder.toLowerCase();
    if (!order.equals("asc") && !order.equals("desc")) return;
    this.sortOrder = order;
  }

  protected @Nullable OrderItem sort() {
    if (sortName == null) return null;
    val order = underLine ? toUnderlineCase(sortName) : sortName;
    return sortOrder.equals("asc") ? asc(order) : desc(order);
  }
}
