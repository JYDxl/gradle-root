@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 角色用户关联
 *
 * @author JYD_XL
 */
@TableName("role_user")
open class RoleUserMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 角色|id */
    @TableField("role_id")
    open var roleId: String? = null

    /** 用户|id */
    @TableField("user_id")
    open var userId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val USER_ID : String = "user_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
