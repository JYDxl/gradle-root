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
@TableName("acl_admin")
open class AclAdminEntity : Entity() {

    /** 会员id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 用户名 */
    @TableField("username")
    open var username: String? = null

    /** 密码 */
    @TableField("password")
    open var password: String? = null

    /** 姓名 */
    @TableField("name")
    open var name: String? = null

    /** 手机 */
    @TableField("phone")
    open var phone: String? = null

    /** 头像地址 */
    @TableField("head_url")
    open var headUrl: String? = null

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

        const val USERNAME : String = "username"

        const val PASSWORD : String = "password"

        const val NAME : String = "name"

        const val PHONE : String = "phone"

        const val HEAD_URL : String = "head_url"

        const val DESCRIPTION : String = "description"

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
