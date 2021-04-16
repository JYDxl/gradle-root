package org.github.base;

import java.io.Serializable;
import java.util.List;

public interface IPage<T> extends Serializable {
    List<T> getRecords();

    long getTotal();
}
