@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 用户
 *
 * @author JYD_XL
 */
@TableName("user")
open class UserMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 登陆名 */
    @TableField("login_name")
    open var loginName: String? = null

    /** 昵称 */
    @TableField("name")
    open var name: String? = null

    /** 密码 */
    @TableField("password")
    open var password: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val LOGIN_NAME : String = "login_name"

        const val NAME : String = "name"

        const val PASSWORD : String = "password"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
