package org.github.order.dto;

import lombok.*;
import org.github.base.IParam;
import org.github.mysql.seata.order.base.entity.TOrderEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CreateOrderBO extends TOrderEntity implements IParam {}
