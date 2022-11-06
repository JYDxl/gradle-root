@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 安全问题数据项表
 *
 * @author JYD_XL
 */
@TableName("tab_safe_question_data")
open class TabSafeQuestionDataEntity : Entity() {

    /** 主键id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 项目id */
    @TableField("project_id")
    open var projectId: String? = null

    /** 问题类型id */
    @TableField("question_type_id")
    open var questionTypeId: String? = null

    /** 问题级别（字典） */
    @TableField("question_level")
    open var questionLevel: String? = null

    /** 整改天数 */
    @TableField("rectify_dates")
    open var rectifyDates: Int? = null

    /** 排查内容 */
    @TableField("check_content")
    open var checkContent: String? = null

    /** 整改要求 */
    @TableField("rectify_require")
    open var rectifyRequire: String? = null

    /** 0 使用  禁用 */
    @TableField("is_use")
    open var isUse: Byte? = null

    /** 创建人 */
    @TableField("creater")
    open var creater: String? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PROJECT_ID : String = "project_id"

        const val QUESTION_TYPE_ID : String = "question_type_id"

        const val QUESTION_LEVEL : String = "question_level"

        const val RECTIFY_DATES : String = "rectify_dates"

        const val CHECK_CONTENT : String = "check_content"

        const val RECTIFY_REQUIRE : String = "rectify_require"

        const val IS_USE : String = "is_use"

        const val CREATER : String = "creater"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

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
