package org.github.util.enums;

import com.google.common.collect.Table;
import lombok.NonNull;
import lombok.val;
import org.apache.commons.lang3.tuple.Triple;
import org.github.base.IEnum;

import java.util.stream.Stream;

import static cn.hutool.core.util.ClassUtil.getPublicMethod;
import static cn.hutool.core.util.ClassUtil.scanPackageBySuper;
import static cn.hutool.core.util.ReflectUtil.invoke;
import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static java.util.Arrays.stream;
import static java.util.stream.Stream.empty;
import static org.apache.commons.lang3.tuple.Triple.of;

public abstract class IEnumUtil {
    public static @NonNull Table<Class<? extends IEnum<?, ?>>, ?, ?> load(@NonNull String packageName) {
        val classes = scanPackageBySuper(packageName, IEnum.class);
        return classes.stream().flatMap(IEnumUtil::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
    }

    @SuppressWarnings("unchecked")
    private static Stream<Triple<Class<? extends IEnum<?, ?>>, ?, ?>> apply(Class<?> clazz) {
        if (!clazz.isEnum()) return empty();
        val method = getPublicMethod(clazz, "values");
        val values = ((IEnum<?, ?>[]) invoke(null, method));
        val token = ((Class<? extends IEnum<?, ?>>) clazz);
        return stream(values).map(v -> of(token, v.getCode(), v.getValue()));
    }
}
