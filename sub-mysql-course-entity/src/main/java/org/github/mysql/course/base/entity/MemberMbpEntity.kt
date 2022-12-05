@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 会员
 *
 * @author JYD_XL
 */
@TableName("member")
open class MemberMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 手机号 */
    @TableField("mobile")
    open var mobile: String? = null

    /** 密码 */
    @TableField("password")
    open var password: String? = null

    /** 昵称 */
    @TableField("name")
    open var name: String? = null

    /** 头像url */
    @TableField("photo")
    open var photo: String? = null

    /** 注册时间 */
    @TableField("register_time")
    open var registerTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val MOBILE : String = "mobile"

        const val PASSWORD : String = "password"

        const val NAME : String = "name"

        const val PHOTO : String = "photo"

        const val REGISTER_TIME : String = "register_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
