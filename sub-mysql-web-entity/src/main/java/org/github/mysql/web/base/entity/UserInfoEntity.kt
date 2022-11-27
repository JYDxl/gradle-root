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
 * 用户表
 *
 * @author JYD_XL
 */
@TableName("user_info")
open class UserInfoEntity : Entity() {

    /** 编号 */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 手机号 */
    @TableField("phone")
    open var phone: String? = null

    /** 用户密码 */
    @TableField("password")
    open var password: String? = null

    /** 用户昵称 */
    @TableField("nick_name")
    open var nickName: String? = null

    /** 状态（0：锁定 1：正常） */
    @TableField("status")
    open var status: Byte? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 逻辑删除(1:已删除，0:未删除) */
    @TableField("is_deleted")
    open var isDeleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PHONE : String = "phone"

        const val PASSWORD : String = "password"

        const val NICK_NAME : String = "nick_name"

        const val STATUS : String = "status"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "UserInfoEntity{" +
        "id=" + id +
        ", phone=" + phone +
        ", password=" + password +
        ", nickName=" + nickName +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
