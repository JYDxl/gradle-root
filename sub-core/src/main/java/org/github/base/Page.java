package org.github.base;

import java.util.StringJoiner;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> implements IPage<T> {
    public Page() {
    }

    public Page(long current, long size) {
        super(current, size);
    }

    public Page(long current, long size, boolean isSearchCount) {
        super(current, size, isSearchCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Page.class.getSimpleName() + "(", ")")
                .add("current=" + current)
                .add("size=" + size)
                .add("total=" + total)
                .add("records=" + records)
                .toString();
    }
}
