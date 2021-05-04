package org.github.base.entity;

import org.github.base.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role")
@ApiModel(value="RoleEntity对象", description="")
public class RoleEntity extends Model<RoleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 名称 */
  @ApiModelProperty(value = "名称")
  @TableField("name")
  private @Nullable String name;

  /** 描述 */
  @ApiModelProperty(value = "描述")
  @TableField("description")
  private @Nullable String description;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
