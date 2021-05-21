package org.github.base.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.github.base.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 安全问题类别
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tab_safe_question_type")
@ApiModel(value="TabSafeQuestionTypeEntity对象", description="安全问题类别")
public class TabSafeQuestionTypeEntity extends IEntity {

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

  /** 父级类型id */
  @ApiModelProperty(value = "父级类型id")
  @TableField("parent_id")
  private String parentId;

  /** 父级类型名称 */
  @ApiModelProperty(value = "父级类型名称")
  @TableField("parent_name")
  private String parentName;

  /** 问题类型编码 */
  @ApiModelProperty(value = "问题类型编码")
  @TableField("type_code")
  private String typeCode;

  /** 问题类型名称 */
  @ApiModelProperty(value = "问题类型名称")
  @TableField("type_name")
  private String typeName;

  /** 备注 */
  @ApiModelProperty(value = "备注")
  @TableField("remark")
  private String remark;

  /** 排序 */
  @ApiModelProperty(value = "排序")
  @TableField("sort")
  private Integer sort;

  /** 创建人 */
  @ApiModelProperty(value = "创建人")
  @TableField("creater")
  private String creater;

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField("create_time")
  private LocalDateTime createTime;

}
