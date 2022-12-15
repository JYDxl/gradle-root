package org.github.core.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.val;
import static cn.hutool.core.lang.Validator.isGeneral;
import static cn.hutool.core.text.CharSequenceUtil.toUnderlineCase;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.asc;
import static com.baomidou.mybatisplus.core.metadata.OrderItem.desc;
import static org.apache.commons.lang3.StringUtils.isBlank;

@ApiModel("排序参数")
@Data
public class Sort implements IBo {
    @ApiModelProperty(value = "使用下划线模式", example = "true")
    private boolean underLine = true;

    @ApiModelProperty(value = "排序字段")
    @Nullable
    private String sortName;

    @ApiModelProperty(value = "排序方式", example = "ASC")
    @NotNull
    private String sortOrder = "ASC";

    @Override
    public String toString() {
        return get();
    }

    public void setSortName(@Nullable String sortName) {
        if (!isGeneral(sortName)) return;
        this.sortName = sortName;
    }

    public void setSortOrder(@Nullable String sortOrder) {
        if (isBlank(sortOrder)) return;
        String order = sortOrder.toUpperCase();
        if (!(order.equals("ASC") || order.equals("DESC"))) return;
        this.sortOrder = order;
    }

    @Nullable
    protected OrderItem sort() {
        if (sortName == null) return null;
        val order = underLine ? toUnderlineCase(sortName) : sortName;
        return sortOrder.equals("ASC") ? asc(order) : desc(order);
    }
}
