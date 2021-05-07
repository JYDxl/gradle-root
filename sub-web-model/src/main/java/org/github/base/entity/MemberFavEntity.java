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
@TableName("member_fav")
@ApiModel(value="MemberFavEntity对象", description="")
public class MemberFavEntity extends Model<MemberFavEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("member_id")
  private @Nullable Long memberId;

  /** 1：资讯	            2：活动	            3：车系 */
  @ApiModelProperty(value = "1：资讯	            2：活动	            3：车系")
  @TableField("fav_type")
  private @Nullable Integer favType;

  @TableField("content_id")
  private @Nullable Long contentId;

  @TableField("fav_time")
  private @Nullable Long favTime;

  @TableField("fav_ip")
  private @Nullable String favIp;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
