package org.github.base;

import java.util.List;

public interface IPage<T> extends IJson {
    List<T> getRecords();

    long getTotal();
}
