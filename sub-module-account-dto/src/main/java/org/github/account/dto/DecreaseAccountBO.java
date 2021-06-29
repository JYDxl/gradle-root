package org.github.account.dto;

import java.math.BigDecimal;

import lombok.*;
import org.github.base.IParam;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
public class DecreaseAccountBO implements IParam {
    @NotNull
    private Long userId;

    @NotNull
    @DecimalMin("0")
    private BigDecimal money;
}
