package org.github.base;

import java.util.List;
import lombok.*;
import static com.google.common.base.MoreObjects.*;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page(PageParam param) {
    super(param.getPageNumber(), param.getPageSize(), param.isSearchCount());
    this.sort(param).sortList(param);
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

  protected Page<T> sort(PageParam param) {
    val sort = param.sort();
    if (sort != null) super.addOrder(sort);
    return this;
  }

  protected void sortList(PageParam param) {
    val list = param.sortList();
    super.addOrder(list);
  }
}
