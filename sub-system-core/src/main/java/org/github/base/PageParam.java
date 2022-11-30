package org.github.base;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.*;
import lombok.experimental.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import static com.google.common.collect.ImmutableList.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@Data
public class PageParam extends Sort {
  /** 当前页 */
  @Min(value = 1, message = "当前页至少为第1页")
  private int pageNum = 1;

  /** 每页条数 */
  @Max(value = 100, message = "每页最多展示100条数据")
  private int pageSize = 10;

  /** 是否搜索总条数 */
  private boolean searchCount = true;

  /** 排序方式 */
  private @NonNull List<Sort> sortList = of();

  @Override
  public void trim() {
    super.trim();
    sortList.forEach(Sort::trim);
  }

  public <T> Page<T> page() {
    return new Page<>(this);
  }

  protected @NonNull List<OrderItem> sortList() {
    return sortList.stream().map(Sort::sort).filter(Objects::nonNull).collect(toImmutableList());
  }
}
