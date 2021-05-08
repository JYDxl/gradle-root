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
@TableName("member_point")
@ApiModel(value="MemberPointEntity对象", description="")
public class MemberPointEntity extends Model<MemberPointEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("point")
  private @Nullable Integer point;

  @TableField("type")
  private @Nullable Integer type;

  @TableField("description")
  private @Nullable String description;

  @TableField("remark")
  private @Nullable String remark;

  @TableField("create_time")
  private @Nullable Long createTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
