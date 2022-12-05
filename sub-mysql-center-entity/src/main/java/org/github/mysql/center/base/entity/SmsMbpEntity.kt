@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 短信验证码
 *
 * @author JYD_XL
 */
@TableName("sms")
open class SmsMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 手机号 */
    @TableField("mobile")
    open var mobile: String? = null

    /** 验证码 */
    @TableField("code")
    open var code: String? = null

    /** 用途|枚举[SmsUseEnum]：REGISTER("R", "注册"), FORGET("F", "忘记密码") */
    @TableField("use")
    open var use: String? = null

    /** 生成时间 */
    @TableField("at")
    open var at: LocalDateTime? = null

    /** 用途|枚举[SmsStatusEnum]：USED("U", "已使用"), NOT_USED("N", "未使用") */
    @TableField("status")
    open var status: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val MOBILE : String = "mobile"

        const val CODE : String = "code"

        const val USE : String = "use"

        const val AT : String = "at"

        const val STATUS : String = "status"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
