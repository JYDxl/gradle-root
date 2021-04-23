package org.github.base;

import java.util.List;

public interface IPage<T> extends IJson, com.baomidou.mybatisplus.core.metadata.IPage<T> {
  List<T> getRecords();

  long getTotal();
}
