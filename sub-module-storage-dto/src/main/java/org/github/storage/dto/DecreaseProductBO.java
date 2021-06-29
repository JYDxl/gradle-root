package org.github.storage.dto;

import lombok.*;
import org.github.base.IParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DecreaseProductBO implements IParam {
    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Integer count;
}
