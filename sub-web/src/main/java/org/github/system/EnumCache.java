package org.github.system;

import com.google.common.collect.Table;
import lombok.Data;
import lombok.NonNull;
import org.github.base.IEnum;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Nullable;
import java.util.Map;

import static org.github.util.enums.EnumUtil.load;

@Data
public class EnumCache implements InitializingBean {
    @NonNull
    private final String packageName;

    private Table<Class<?>, ?, ?> table;

    public EnumCache(@NonNull String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        table = load(packageName, null);
    }

    @SuppressWarnings("unchecked")
    public @Nullable
    <C, V, E extends Class<? extends IEnum<C, V>>> V get(@NonNull E clazz, @Nullable C code) {
        return code == null ? null : (V) table.get(clazz, code);
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
