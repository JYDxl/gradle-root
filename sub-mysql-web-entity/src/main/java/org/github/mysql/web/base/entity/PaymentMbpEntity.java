package org.github.mysql.web.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付表
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-26
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("payment")
@ApiModel(value="PaymentMbpEntity对象", description="支付表")
public class PaymentMbpEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** id */
  @ApiModelProperty(value = "id")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** serial */
  @ApiModelProperty(value = "serial")
  @TableField("serial")
  private String serial;

}
