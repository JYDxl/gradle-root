package org.github.base;

import java.util.List;
import java.util.Objects;
import lombok.*;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import static com.google.common.collect.ImmutableList.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class PageParam extends Sort implements IParam {
  private int pageNum = 1;

  private int pageSize = 10;

  private boolean searchCount = true;

  private @NonNull List<Sort> sortList = of();

  protected @NonNull List<OrderItem> sortList() {
    return sortList.stream().map(Sort::sort).filter(Objects::nonNull).collect(toImmutableList());
  }
}
