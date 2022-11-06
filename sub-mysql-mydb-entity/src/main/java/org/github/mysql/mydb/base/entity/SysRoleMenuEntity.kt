@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 角色-菜单关系表
 *
 * @author JYD_XL
 */
@TableName("sys_role_menu")
open class SysRoleMenuEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 角色id */
    @TableField("role_id")
    open var roleId: Long? = null

    /** 菜单id */
    @TableField("menu_id")
    open var menuId: Long? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val MENU_ID : String = "menu_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysRoleMenuEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}"
    }

}
