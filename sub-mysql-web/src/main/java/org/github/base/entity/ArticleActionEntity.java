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
@TableName("article_action")
@ApiModel(value="ArticleActionEntity对象", description="")
public class ArticleActionEntity extends Model<ArticleActionEntity> {

  /** UID */
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private @Nullable Long id;

  @TableField("article_id")
  private @Nullable Long articleId;

  /** 0：未启用
            1：已启用 */
  @ApiModelProperty(value = "0：未启用
            1：已启用")
  @TableField("operator_uid")
  private @Nullable Integer operatorUid;

  /** 0：非默认摘要
            1：默认摘要 */
  @ApiModelProperty(value = "0：非默认摘要
            1：默认摘要")
  @TableField("operator_username")
  private @Nullable String operatorUsername;

  @TableField("create_time")
  private @Nullable Long createTime;

  @TableField("content")
  private @Nullable String content;

  /** 1：新增
            2：编辑
            3：审核
            4：删除 */
  @ApiModelProperty(value = "1：新增
            2：编辑
            3：审核
            4：删除")
  @TableField("operate_type")
  private @Nullable Integer operateType;

  @Override
  public Serializable pkVal() {
    return this.id;
  }

}
