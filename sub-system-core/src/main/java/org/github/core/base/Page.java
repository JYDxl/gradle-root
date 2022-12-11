package org.github.core.base;

import java.util.List;
import lombok.NonNull;
import lombok.val;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
  public Page(PageBo bo) {
    super(bo.getPageNum(), bo.getPageSize(), bo.isSearchCount());
    this.sort(bo).sortList(bo);
  }

  protected void sortList(PageBo bo) {
    val list = bo.sortList();
    super.addOrder(list);
  }

  protected Page<T> sort(PageBo bo) {
    val sort = bo.sort();
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
