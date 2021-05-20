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
 * @since 2021-05-20
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("activity")
@ApiModel(value="ActivityEntity对象", description="")
public class ActivityEntity extends Model<ActivityEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("title")
  private @Nullable String title;

  @TableField("category_id")
  private @Nullable Integer categoryId;

  @TableField("url")
  private @Nullable String url;

  /** 0：未开始
            1：进行中
            2：已结束 */
  @ApiModelProperty(value = "0：未开始 1：进行中 2：已结束")
  @TableField("state")
  private @Nullable Integer state;

  @TableField("summary")
  private @Nullable String summary;

  @TableField("description")
  private @Nullable String description;

  @TableField("link")
  private @Nullable String link;

  @TableField("begin_time")
  private @Nullable Long beginTime;

  @TableField("end_time")
  private @Nullable Long endTime;

  /** 0：否
            1：是 */
  @ApiModelProperty(value = "0：否 1：是")
  @TableField("channel_top")
  private @Nullable Integer channelTop;

  /** 0：否
            1：是 */
  @ApiModelProperty(value = "0：否 1：是")
  @TableField("home_top")
  private @Nullable Integer homeTop;

  @TableField("pv_count")
  private @Nullable Integer pvCount;

  @TableField("uv_count")
  private @Nullable Integer uvCount;

  @TableField("up_count")
  private @Nullable Integer upCount;

  @TableField("fav_count")
  private @Nullable Integer favCount;

  /** 0：未发布
            1：已发布
            2：撤销发布 */
  @ApiModelProperty(value = "0：未发布 1：已发布 2：撤销发布")
  @TableField("publish_state")
  private @Nullable Integer publishState;

  @TableField("create_uid")
  private @Nullable Integer createUid;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("author")
  private @Nullable String author;

  @TableField("unpublish_uname")
  private @Nullable String unpublishUname;

  @TableField("unpublish_time")
  private @Nullable Long unpublishTime;

  @TableField("seo_keywords")
  private @Nullable String seoKeywords;

  @TableField("sdk_path")
  private @Nullable String sdkPath;

  @TableField("like_count")
  private @Nullable Integer likeCount;

  @TableField("share_count")
  private @Nullable Integer shareCount;

  @TableField("view_count")
  private @Nullable Integer viewCount;

  @TableField("seo_description")
  private @Nullable String seoDescription;

  @TableField("tags")
  private @Nullable String tags;

  @TableField("cover_pic")
  private @Nullable String coverPic;

  @TableField("cars")
  private @Nullable String cars;

  @TableField("sdk_id")
  private @Nullable Integer sdkId;

  @TableField("sdk_title")
  private @Nullable String sdkTitle;

  @TableField("dealer")
  private @Nullable String dealer;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
