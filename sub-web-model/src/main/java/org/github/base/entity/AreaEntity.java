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
 * @since 2021-05-08
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("area")
@ApiModel(value="AreaEntity对象", description="")
public class AreaEntity extends Model<AreaEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  /** 0：未删除	            1：已删除 */
  @ApiModelProperty(value = "0：未删除	            1：已删除")
  @TableField("pid")
  private @Nullable Integer pid;

  @TableField("areacode")
  private @Nullable String areacode;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
