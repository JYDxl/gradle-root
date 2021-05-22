package org.github.mysql.web.base.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 安全问题库
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tab_safe_question_data")
@ApiModel(value="TabSafeQuestionDataEntity对象", description="安全问题库")
public class TabSafeQuestionDataEntity extends IEntity {

  /** UID */
  private static final long serialVersionUID = 1L;

  /** 主键id */
  @ApiModelProperty(value = "主键id")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;

  /** 项目id */
  @ApiModelProperty(value = "项目id")
  @TableField("project_id")
  private String projectId;

  /** 问题类型id */
  @ApiModelProperty(value = "问题类型id")
  @TableField("question_type_id")
  private String questionTypeId;

  /** 问题级别（字典） */
  @ApiModelProperty(value = "问题级别（字典）")
  @TableField("question_level")
  private String questionLevel;

  /** 整改天数 */
  @ApiModelProperty(value = "整改天数")
  @TableField("rectify_dates")
  private Integer rectifyDates;

  /** 排查内容 */
  @ApiModelProperty(value = "排查内容")
  @TableField("check_content")
  private String checkContent;

  /** 整改要求 */
  @ApiModelProperty(value = "整改要求")
  @TableField("rectify_require")
  private String rectifyRequire;

  /** 0 使用  禁用 */
  @ApiModelProperty(value = "0 使用  禁用")
  @TableField("is_use")
  private Integer isUse;

  /** 创建人 */
  @ApiModelProperty(value = "创建人")
  @TableField("creater")
  private String creater;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

}
