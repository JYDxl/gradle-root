package org.github.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;
import java.util.function.Function;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.Collections.emptyList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageInfo<V> {
    private long total = 0;

    private @NonNull Collection<V> data = emptyList();

    /** Generator. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T, R extends T> @NonNull PageInfo<R> of(@NonNull IPage<T> page) {
        return new PageInfo(page.getTotal(), page.getRecords());
    }

    /** Generator. */
    public static <V> @NonNull PageInfo<V> of() {
        return new PageInfo<>();
    }

    /** Generator. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T, R extends T> @NonNull PageInfo<R> of(long total, @NonNull Collection<T> data) {
        return new PageInfo(total, data);
    }

    /** Generator. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T, R extends T> @NonNull PageInfo<R> of(@NonNull IPage<T> page, @NonNull Function<T, R> mapper) {
        return new PageInfo(page.getTotal(), page.getRecords().stream().map(mapper).collect(toImmutableList()));
    }

    /** Generator. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T, R extends T> @NonNull PageInfo<R> of(@NonNull IPage<T> page, @NonNull Collection<R> data) {
        return new PageInfo(page.getTotal(), data);
    }
}
