package org.github.order.dto;

import lombok.*;
import org.github.base.IParam;
import org.github.mysql.seata.order.base.entity.TOrderEntity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CreateOrderBO extends TOrderEntity implements IParam {
    @NotNull
    @Override
    public Long getUserId() {
        return super.getUserId();
    }

    @Null
    @Override
    public Long getOrderId() {
        return super.getOrderId();
    }

    @NotNull
    @Override
    public Long getProductId() {
        return super.getProductId();
    }

    @NotNull
    @Min(1)
    @Override
    public Integer getNum() {
        return super.getNum();
    }

    @NotNull
    @DecimalMin("0")
    @Override
    public BigDecimal getMoney() {
        return super.getMoney();
    }

    @Null
    @Override
    public Integer getStatus() {
        return super.getStatus();
    }
}
