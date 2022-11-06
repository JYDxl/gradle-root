@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 用户表
 *
 * @author JYD_XL
 */
@TableName("sys_user")
open class SysUserEntity : Entity() {

    /** 主键 */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    open var userId: Long? = null

    /** 用户名 */
    @TableField("username")
    open var username: String? = null

    /** 密码 */
    @TableField("password")
    open var password: String? = null

    /** 盐 */
    @TableField("salt")
    open var salt: String? = null

    /** 启用状态 0：禁用 1：启用 */
    @TableField("enabled")
    open var enabled: Byte? = null

    /** 昵称 */
    @TableField("nickname")
    open var nickname: String? = null

    /** 邮箱 */
    @TableField("email")
    open var email: String? = null

    /** 手机号 */
    @TableField("mobile")
    open var mobile: String? = null

    /** 创建人id */
    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    open var creatorId: Long? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 修改人id */
    @TableField("modifier_id")
    open var modifierId: Long? = null

    /** 修改时间 */
    @TableField("modify_time")
    open var modifyTime: LocalDateTime? = null

    /** 删除状态 0：未删除 1：已删除 */
    @TableField("deleted")
    open var deleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val USER_ID : String = "user_id"

        const val USERNAME : String = "username"

        const val PASSWORD : String = "password"

        const val SALT : String = "salt"

        const val ENABLED : String = "enabled"

        const val NICKNAME : String = "nickname"

        const val EMAIL : String = "email"

        const val MOBILE : String = "mobile"

        const val CREATOR_ID : String = "creator_id"

        const val CREATE_TIME : String = "create_time"

        const val MODIFIER_ID : String = "modifier_id"

        const val MODIFY_TIME : String = "modify_time"

        const val DELETED : String = "deleted"

    }

    override fun pkVal(): Serializable? {
        return userId
    }

    override fun toString(): String {
        return "SysUserEntity{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", enabled=" + enabled +
        ", nickname=" + nickname +
        ", email=" + email +
        ", mobile=" + mobile +
        ", creatorId=" + creatorId +
        ", createTime=" + createTime +
        ", modifierId=" + modifierId +
        ", modifyTime=" + modifyTime +
        ", deleted=" + deleted +
        "}"
    }

}
