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
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("operate_log")
@ApiModel(value="OperateLogEntity对象", description="")
public class OperateLogEntity extends Model<OperateLogEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("operate_time")
  private @Nullable Integer operateTime;

  @TableField("operate_uid")
  private @Nullable Integer operateUid;

  /** 0：未接收	            1：已接收 */
  @ApiModelProperty(value = "0：未接收	            1：已接收")
  @TableField("table_name")
  private @Nullable String tableName;

  @TableField("table_disname")
  private @Nullable String tableDisname;

  /** 0：未阅读	            1：已阅读 */
  @ApiModelProperty(value = "0：未阅读	            1：已阅读")
  @TableField("data_id")
  private @Nullable Long dataId;

  @TableField("operate_desc")
  private @Nullable String operateDesc;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
