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
 * 角色表
 *
 * @author JYD_XL
 */
@TableName("sys_role")
open class SysRoleEntity : Entity() {

    /** 主键 */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    open var roleId: Long? = null

    /** 角色名称 */
    @TableField("role_name")
    open var roleName: String? = null

    /** 角色编码 */
    @TableField("role_code")
    open var roleCode: String? = null

    /** 备注 */
    @TableField("remark")
    open var remark: String? = null

    /** 创建者ID */
    @TableField("create_user_id")
    open var createUserId: Long? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ROLE_ID : String = "role_id"

        const val ROLE_NAME : String = "role_name"

        const val ROLE_CODE : String = "role_code"

        const val REMARK : String = "remark"

        const val CREATE_USER_ID : String = "create_user_id"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): Serializable? {
        return roleId
    }

    override fun toString(): String {
        return "SysRoleEntity{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleCode=" + roleCode +
        ", remark=" + remark +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        "}"
    }

}
