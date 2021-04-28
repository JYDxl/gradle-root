package org.github.cache;

import com.google.common.collect.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.base.IEnum;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Nullable;
import java.util.Map;

import static org.github.util.enums.IEnumUtil.load;

@Slf4j
@Data
public class EnumCache implements InitializingBean {
    @NonNull
    private final String packageName;

    private Table<Class<? extends IEnum<?, ?>>, ?, ?> table;

    public EnumCache(@NonNull String packageName) {
        this.packageName = packageName;
    }

    @Deprecated
    @Override
    public void afterPropertiesSet() throws Exception {
        table = load(packageName);
    }

    @SuppressWarnings("unchecked")
    public @Nullable <C, V, E extends Class<? extends IEnum<C, V>>> V get(@NonNull E clazz, @Nullable C code) {
        if (code == null) return null;
        val value = table.get(clazz, code);
        if (value == null) log.warn("在常量枚举[{}]中发现未知的类型编码: {}", clazz, code);
        return (V) value;
    }

    @SuppressWarnings("unchecked")
    public @NonNull <C, V, E extends Class<? extends IEnum<C, V>>> Map<C, V> getAll(@NonNull E clazz) {
        return (Map<C, V>) table.row(clazz);
    }

    @Deprecated
    public void setTable(Table<Class<?>, ?, ?> table) {
        throw new UnsupportedOperationException();
    }
}
