package org.github.core.base;

import java.util.List;
import lombok.*;
import static com.google.common.base.MoreObjects.*;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page(PageParam param) {
    super(param.getPageNum(), param.getPageSize(), param.isSearchCount());
    this.sort(param).sortList(param);
  }

  protected void sortList(PageParam param) {
    val list = param.sortList();
    super.addOrder(list);
  }

  protected Page<T> sort(PageParam param) {
    val sort = param.sort();
    if (sort != null) super.addOrder(sort);
    return this;
  }

  @Override
  @NonNull
  public List<T> getRecords() {
    return super.getRecords();
  }

  @Override
  public String toString() {
    return toStringHelper(this)
      .add("num", current)
      .add("size", size)
      .add("data", records)
      .add("total", total)
      .add("order", orders)
      .toString();
  }
}
