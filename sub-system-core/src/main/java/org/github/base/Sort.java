package org.github.base;

import javax.annotation.Nullable;
import lombok.*;
import lombok.experimental.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import static cn.hutool.core.lang.Validator.*;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.*;

@Accessors(chain = true)
@Data
public class Sort {
  /** 是否使用下划线模式 */
  private boolean underLine = true;

  /** 排序字段 */
  private @Nullable String sortName;

  /** 排序方式 */
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
