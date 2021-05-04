package org.github.base;

import java.util.List;
import lombok.*;
import static com.google.common.base.MoreObjects.*;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page() {}

  public Page(long current, long size) {
    super(current, size);
  }

  public Page(PageParam param) {
    this(param.getPageNum(), param.getPageSize(), param.isSearchCount());
  }

  public Page(long current, long size, boolean isSearchCount) {
    super(current, size, isSearchCount);
  }

  @Override
  public @NonNull List<T> getRecords() {
    return super.getRecords();
  }

  @Override
  public String toString() {
    return toStringHelper(this)
      .add("current", current)
      .add("size", size)
      .add("records", records)
      .add("total", total)
      .toString();
  }
}
