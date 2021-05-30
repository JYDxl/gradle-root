@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import java.time.LocalDateTime
import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 安全问题库
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@TableName("tab_safe_question_data")
@ApiModel(value="TabSafeQuestionDataEntity对象", description="安全问题库")
open class TabSafeQuestionDataEntity : IEntity() {

    /** 主键id */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 项目id */
    @ApiModelProperty(value = "项目id")
    @TableField("project_id")
    open var projectId: String? = null

    /** 问题类型id */
    @ApiModelProperty(value = "问题类型id")
    @TableField("question_type_id")
    open var questionTypeId: String? = null

    /** 问题级别（字典） */
    @ApiModelProperty(value = "问题级别（字典）")
    @TableField("question_level")
    open var questionLevel: String? = null

    /** 整改天数 */
    @ApiModelProperty(value = "整改天数")
    @TableField("rectify_dates")
    open var rectifyDates: Int? = null

    /** 排查内容 */
    @ApiModelProperty(value = "排查内容")
    @TableField("check_content")
    open var checkContent: String? = null

    /** 整改要求 */
    @ApiModelProperty(value = "整改要求")
    @TableField("rectify_require")
    open var rectifyRequire: String? = null

    /** 0 使用  禁用 */
    @ApiModelProperty(value = "0 使用  禁用")
    @TableField("is_use")
    open var isUse: Int? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    @TableField("creater")
    open var creater: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    override fun toString(): String {
        return "TabSafeQuestionDataEntity{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", questionTypeId=" + questionTypeId +
        ", questionLevel=" + questionLevel +
        ", rectifyDates=" + rectifyDates +
        ", checkContent=" + checkContent +
        ", rectifyRequire=" + rectifyRequire +
        ", isUse=" + isUse +
        ", creater=" + creater +
        ", createTime=" + createTime +
        "}"
    }

}