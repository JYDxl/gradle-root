package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("permission")
@ApiModel(value="PermissionEntity对象", description="")
public class PermissionEntity extends Model<PermissionEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /** 名称 */
  @ApiModelProperty(value = "名称")
  @TableField("name")
  private String name;

  /** 接口路径 */
  @ApiModelProperty(value = "接口路径")
  @TableField("url")
  private String url;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
