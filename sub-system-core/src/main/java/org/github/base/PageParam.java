package org.github.base;

import java.util.List;
import java.util.Objects;
import lombok.*;
import lombok.experimental.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import static com.google.common.collect.ImmutableList.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@Data
public class PageParam extends Sort implements IParam {
  /** 当前页 */
  private int pageNum = 1;

  /** 每页条数 */
  private int pageSize = 10;

  /** 是否搜索总条数 */
  private boolean searchCount = true;

  /** 排序方式 */
  private @NonNull List<Sort> sortList = of();

  protected @NonNull List<OrderItem> sortList() {
    return sortList.stream().map(Sort::sort).filter(Objects::nonNull).collect(toImmutableList());
  }
}
