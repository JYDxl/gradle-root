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
@TableName("tag")
@ApiModel(value="TagEntity对象", description="")
public class TagEntity extends Model<TagEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  @TableField("name")
  private @Nullable String name;

  /** 0：未删除	            1：已删除 */
  @ApiModelProperty(value = "0：未删除	            1：已删除")
  @TableField("is_deleted")
  private @Nullable Integer isDeleted;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("last_update_time")
  private @Nullable Long lastUpdateTime;

  @TableField("click_count")
  private @Nullable Long clickCount;

  /** 0：系统标签	            1：用户标签 */
  @ApiModelProperty(value = "0：系统标签	            1：用户标签")
  @TableField("type")
  private @Nullable Integer type;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
