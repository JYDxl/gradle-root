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
@TableName("article_category")
@ApiModel(value="ArticleCategoryEntity对象", description="")
public class ArticleCategoryEntity extends Model<ArticleCategoryEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Integer id;

  /** 0：未启用	            1：已启用 */
  @ApiModelProperty(value = "0：未启用	            1：已启用")
  @TableField("name")
  private @Nullable String name;

  /** 0：未删除	            1：已删除 */
  @ApiModelProperty(value = "0：未删除	            1：已删除")
  @TableField("is_deleted")
  private @Nullable Integer isDeleted;

  @TableField("sort_num")
  private @Nullable Integer sortNum;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("last_update_time")
  private @Nullable Long lastUpdateTime;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
