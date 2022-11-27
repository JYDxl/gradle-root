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
 * 角色
 *
 * @author JYD_XL
 */
@TableName("acl_role")
open class AclRoleEntity : Entity() {

    /** 角色id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 角色名称 */
    @TableField("role_name")
    open var roleName: String? = null

    /** 角色编码 */
    @TableField("role_code")
    open var roleCode: String? = null

    /** 描述 */
    @TableField("description")
    open var description: String? = null

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

        const val ROLE_NAME : String = "role_name"

        const val ROLE_CODE : String = "role_code"

        const val DESCRIPTION : String = "description"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "AclRoleEntity{" +
        "id=" + id +
        ", roleName=" + roleName +
        ", roleCode=" + roleCode +
        ", description=" + description +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
