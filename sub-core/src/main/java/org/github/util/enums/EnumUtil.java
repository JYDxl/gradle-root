package org.github.util.enums;

import com.google.common.collect.Table;
import com.google.common.reflect.ClassPath.ClassInfo;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.lang3.tuple.Triple;
import org.github.base.IEnum;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static com.google.common.reflect.ClassPath.from;
import static com.google.common.reflect.Invokable.from;
import static java.util.Arrays.stream;
import static java.util.stream.Stream.empty;

public abstract class EnumUtil {
    public static @NonNull Table<Class<?>, ?, ?> load(@NonNull String packageName, @Nullable ClassLoader classLoader) throws IOException {
        val loader = classLoader == null ? EnumUtil.class.getClassLoader() : classLoader;
        val classes = from(loader).getTopLevelClasses(packageName);
        return classes.stream().flatMap(EnumUtil::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
    }

    @SneakyThrows
    private static Stream<Triple<Class<?>, ?, ?>> apply(ClassInfo info) {
        val clazz = info.load();
        if (!(IEnum.class.isAssignableFrom(clazz) && clazz.isEnum())) return empty();
        val method = clazz.getMethod("values");
        val invokable = from(method);
        val values = ((IEnum<?, ?>[]) invokable.invoke(null));
        return stream(values).map(v -> Triple.of(clazz, v.getCode(), v.getValue()));
    }
}
