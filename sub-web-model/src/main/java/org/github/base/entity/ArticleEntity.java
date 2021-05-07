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
@TableName("article")
@ApiModel(value="ArticleEntity对象", description="")
public class ArticleEntity extends Model<ArticleEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("title")
  private @Nullable String title;

  /** 0：未启用	            1：已启用 */
  @ApiModelProperty(value = "0：未启用	            1：已启用")
  @TableField("category_id")
  private @Nullable Integer categoryId;

  @TableField("source")
  private @Nullable String source;

  @TableField("author")
  private @Nullable String author;

  @TableField("summary")
  private @Nullable String summary;

  @TableField("cover_pic")
  private @Nullable String coverPic;

  @TableField("thumb_pic")
  private @Nullable String thumbPic;

  /** 此字段为冗余字段，存放逗号分割的标签ID，用于便捷的进行资讯的筛选等操作，真正的资讯和标签的关联关系存放在article_tag表中 */
  @ApiModelProperty(value = "此字段为冗余字段，存放逗号分割的标签ID，用于便捷的进行资讯的筛选等操作，真正的资讯和标签的关联关系存放在article_tag表中")
  @TableField("tags")
  private @Nullable String tags;

  @TableField("content")
  private @Nullable String content;

  @TableField("preview_url")
  private @Nullable String previewUrl;

  @TableField("qrcode_url")
  private @Nullable String qrcodeUrl;

  @TableField("pv_count")
  private @Nullable Integer pvCount;

  @TableField("uv_count")
  private @Nullable Integer uvCount;

  @TableField("comment_count")
  private @Nullable Integer commentCount;

  @TableField("like_count")
  private @Nullable Integer likeCount;

  @TableField("fav_count")
  private @Nullable Integer favCount;

  @TableField("share_count")
  private @Nullable Integer shareCount;

  @TableField("channel_top")
  private @Nullable Integer channelTop;

  @TableField("home_top")
  private @Nullable Integer homeTop;

  /** 如果是外部资源，那么该字段值为0 */
  @ApiModelProperty(value = "如果是外部资源，那么该字段值为0")
  @TableField("create_uid")
  private @Nullable Integer createUid;

  @TableField("create_uname")
  private @Nullable String createUname;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("submit_uid")
  private @Nullable Integer submitUid;

  @TableField("submit_time")
  private @Nullable Long submitTime;

  /** 0：草稿；	            1：等待内容审核；	            2：内容审核通过；	            3：内容审核退回； */
  @ApiModelProperty(value = "0：草稿；	            1：等待内容审核；	            2：内容审核通过；	            3：内容审核退回；")
  @TableField("state")
  private @Nullable Integer state;

  /** 该字段用于内容列表按照审核状态降序排列：	            0：草稿；	            1：内容审核通过；	            2：等待内容审核；	            3：内容审核退回； */
  @ApiModelProperty(value = "该字段用于内容列表按照审核状态降序排列：	            0：草稿；	            1：内容审核通过；	            2：等待内容审核；	            3：内容审核退回；")
  @TableField("state_order")
  private @Nullable Integer stateOrder;

  @TableField("last_audit_uid")
  private @Nullable Integer lastAuditUid;

  @TableField("last_audit_username")
  private @Nullable String lastAuditUsername;

  /** 仅当发布审核通过时才记录该时间 */
  @ApiModelProperty(value = "仅当发布审核通过时才记录该时间")
  @TableField("last_audit_time")
  private @Nullable Long lastAuditTime;

  @TableField("last_reject_reason")
  private @Nullable String lastRejectReason;

  /** 0：未发布	            1：已发布 */
  @ApiModelProperty(value = "0：未发布	            1：已发布")
  @TableField("publish_state")
  private @Nullable Integer publishState;

  @TableField("publish_uid")
  private @Nullable Integer publishUid;

  @TableField("publish_uname")
  private @Nullable String publishUname;

  @TableField("publish_time")
  private @Nullable Long publishTime;

  @TableField("unpublish_uid")
  private @Nullable Integer unpublishUid;

  @TableField("unpublish_uname")
  private @Nullable String unpublishUname;

  @TableField("unpublish_time")
  private @Nullable Long unpublishTime;

  @TableField("unpublish_reason")
  private @Nullable String unpublishReason;

  @TableField("last_update_uid")
  private @Nullable Integer lastUpdateUid;

  @TableField("last_update_uname")
  private @Nullable String lastUpdateUname;

  @TableField("last_update_time")
  private @Nullable Long lastUpdateTime;

  @TableField("seo_keywords")
  private @Nullable String seoKeywords;

  @TableField("seo_description")
  private @Nullable String seoDescription;

  /** 0：不允许	            1：允许 */
  @ApiModelProperty(value = "0：不允许	            1：允许")
  @TableField("allow_up")
  private @Nullable Integer allowUp;

  /** 0：不允许	            1：允许 */
  @ApiModelProperty(value = "0：不允许	            1：允许")
  @TableField("allow_fav")
  private @Nullable Integer allowFav;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
