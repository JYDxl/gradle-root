@file:Suppress("UnusedImport", "unused")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 权限
 *
 * @author JYD_XL
 */
@TableName("acl_permission")
open class AclPermissionEntity : Entity() {

    /** 编号 */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 所属上级 */
    @TableField("parent_id")
    open var parentId: Long? = null

    /** 权限名称 */
    @TableField("name")
    open var name: String? = null

    /** 菜单路径 */
    @TableField("url")
    open var url: String? = null

    /** 权限标识 */
    @TableField("code")
    open var code: String? = null

    /** 类型(1:菜单,2:按钮) */
    @TableField("type")
    open var type: Byte? = null

    /** 排序 */
    @TableField("sort")
    open var sort: Byte? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 删除标记（0:不可用 1:可用） */
    @TableField("is_deleted")
    open var isDeleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PARENT_ID : String = "parent_id"

        const val NAME : String = "name"

        const val URL : String = "url"

        const val CODE : String = "code"

        const val TYPE : String = "type"

        const val SORT : String = "sort"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
