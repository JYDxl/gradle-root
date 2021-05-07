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
@TableName("article_tag")
@ApiModel(value="ArticleTagEntity对象", description="")
public class ArticleTagEntity extends Model<ArticleTagEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  /** 0：未启用	            1：已启用 */
  @ApiModelProperty(value = "0：未启用	            1：已启用")
  @TableField("tag_id")
  private @Nullable Integer tagId;

  @TableField("article_id")
  private @Nullable Long articleId;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
