package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_functions")
@ApiModel(value="TbFunctionsEntity对象", description="")
public class TbFunctionsEntity extends Model<TbFunctionsEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "func_id", type = IdType.AUTO)
  private Integer funcId;

  @TableField("func_name")
  private String funcName;

  @TableField("func_url")
  private String funcUrl;

  @TableField("func_code")
  private String funcCode;

  @TableField("parent_id")
  private Integer parentId;

  @TableField("func_type")
  private Integer funcType;

  @TableField("status")
  private Integer status;

  @TableField("sort_num")
  private Integer sortNum;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("update_time")
  private LocalDateTime updateTime;

  @Override
  protected Serializable pkVal() {
    return this.funcId;
  }

}
