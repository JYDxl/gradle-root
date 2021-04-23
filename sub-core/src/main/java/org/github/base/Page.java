package org.github.base;

import static com.google.common.base.MoreObjects.*;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page() {}

  public Page(long current, long size) {
    super(current, size);
  }

  public Page(long current, long size, boolean isSearchCount) {
    super(current, size, isSearchCount);
  }

  public Page(PageParam param) {
    this(param.getPageNum(), param.getPageSize(), param.isSearchCount());
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
