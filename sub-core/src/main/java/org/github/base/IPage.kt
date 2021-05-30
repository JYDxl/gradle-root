package org.github.base;

import java.util.List;
import lombok.*;

public interface IPage<T> extends IJson, com.baomidou.mybatisplus.core.metadata.IPage<T> {
  @NonNull List<T> getRecords();

  long getTotal();
}
