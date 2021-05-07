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
@TableName("member_tag")
@ApiModel(value="MemberTagEntity对象", description="")
public class MemberTagEntity extends Model<MemberTagEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("member_id")
  private @Nullable Long memberId;

  @TableField("tag_id")
  private @Nullable Integer tagId;

  @TableField("create_time")
  private @Nullable Long createTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
