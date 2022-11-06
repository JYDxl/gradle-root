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
 * 安全问题类别表
 *
 * @author JYD_XL
 */
@TableName("tab_safe_question_type")
open class TabSafeQuestionTypeEntity : Entity() {

    /** 主键id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 项目id */
    @TableField("project_id")
    open var projectId: String? = null

    /** 父级类型id */
    @TableField("parent_id")
    open var parentId: String? = null

    /** 父级类型名称 */
    @TableField("parent_name")
    open var parentName: String? = null

    /** 问题类型编码 */
    @TableField("type_code")
    open var typeCode: String? = null

    /** 问题类型名称 */
    @TableField("type_name")
    open var typeName: String? = null

    /** 备注 */
    @TableField("remark")
    open var remark: String? = null

    /** 排序 */
    @TableField("sort")
    open var sort: Int? = null

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

        const val PARENT_ID : String = "parent_id"

        const val PARENT_NAME : String = "parent_name"

        const val TYPE_CODE : String = "type_code"

        const val TYPE_NAME : String = "type_name"

        const val REMARK : String = "remark"

        const val SORT : String = "sort"

        const val CREATER : String = "creater"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "TabSafeQuestionTypeEntity{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", parentId=" + parentId +
        ", parentName=" + parentName +
        ", typeCode=" + typeCode +
        ", typeName=" + typeName +
        ", remark=" + remark +
        ", sort=" + sort +
        ", creater=" + creater +
        ", createTime=" + createTime +
        "}"
    }

}
