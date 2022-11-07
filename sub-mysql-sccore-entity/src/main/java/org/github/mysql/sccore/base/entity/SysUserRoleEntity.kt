@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 用户角色管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_user_role")
open class SysUserRoleEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 用户ID */
    @TableField("user_id")
    open var userId: Long? = null

    /** 角色ID */
    @TableField("role_id")
    open var roleId: Long? = null

    /** 创建人 */
    @TableField("creator_name")
    open var creatorName: String? = null

    /** 创建时间 */
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 修改人 */
    @TableField("updater_name")
    open var updaterName: String? = null

    /** 修改时间 */
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val ROLE_ID : String = "role_id"

        const val CREATOR_NAME : String = "creator_name"

        const val CREATED_TIME : String = "created_time"

        const val UPDATER_NAME : String = "updater_name"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysUserRoleEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", creatorName=" + creatorName +
        ", createdTime=" + createdTime +
        ", updaterName=" + updaterName +
        ", updatedTime=" + updatedTime +
        "}"
    }

}
