@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 用户-角色关系表
 *
 * @author JYD_XL
 */
@TableName("sys_user_role")
open class SysUserRoleEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 用户id */
    @TableField("user_id")
    open var userId: Long? = null

    /** 角色id */
    @TableField("role_id")
    open var roleId: Long? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val ROLE_ID : String = "role_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysUserRoleEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}"
    }

}
