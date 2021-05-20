package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import javax.annotation.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统配置信息表
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_config")
@ApiModel(value="SysConfigEntity对象", description="系统配置信息表")
public class SysConfigEntity extends Model<SysConfigEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  /** key */
  @ApiModelProperty(value = "key")
  @TableField("key")
  private @Nullable String key;

  /** value */
  @ApiModelProperty(value = "value")
  @TableField("value")
  private @Nullable String value;

  /** 状态   0：隐藏   1：显示 */
  @ApiModelProperty(value = "状态   0：隐藏   1：显示")
  @TableField("status")
  private @Nullable Integer status;

  /** 备注 */
  @ApiModelProperty(value = "备注")
  @TableField("remark")
  private @Nullable String remark;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
