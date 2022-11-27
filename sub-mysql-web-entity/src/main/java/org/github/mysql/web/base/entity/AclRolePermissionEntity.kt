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
 * 角色权限
 *
 * @author JYD_XL
 */
@TableName("acl_role_permission")
open class AclRolePermissionEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    @TableField("role_id")
    open var roleId: Long? = null

    @TableField("permission_id")
    open var permissionId: Long? = null

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

        const val ROLE_ID : String = "role_id"

        const val PERMISSION_ID : String = "permission_id"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "AclRolePermissionEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
