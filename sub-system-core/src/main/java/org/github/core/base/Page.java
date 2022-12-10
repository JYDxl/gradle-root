package org.github.core.base;

import java.util.List;
import lombok.NonNull;
import lombok.val;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page(PageBo param) {
    super(param.getPageNum(), param.getPageSize(), param.isSearchCount());
    this.sort(param).sortList(param);
  }

  protected void sortList(PageBo param) {
    val list = param.sortList();
    super.addOrder(list);
  }

  protected Page<T> sort(PageBo param) {
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
