@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 短信验证码
 *
 * @author JYD_XL
 */
@TableName("sms")
@ApiModel("短信验证码")
open class SmsMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("手机号")
    @TableField("mobile")
    open var mobile: String? = null

    @ApiModelProperty("验证码")
    @TableField("code")
    open var code: String? = null

    @ApiModelProperty("用途|枚举[SmsUseEnum]：REGISTER(\"R\", \"注册\"), FORGET(\"F\", \"忘记密码\")")
    @TableField("use")
    open var use: String? = null

    @ApiModelProperty("生成时间")
    @TableField("at")
    open var at: LocalDateTime? = null

    @ApiModelProperty("用途|枚举[SmsStatusEnum]：USED(\"U\", \"已使用\"), NOT_USED(\"N\", \"未使用\")")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SmsMbpPo) return false
        if (id != other.id) return false
        if (mobile != other.mobile) return false
        if (code != other.code) return false
        if (use != other.use) return false
        if (at != other.at) return false
        if (status != other.status) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (mobile?.hashCode() ?: 0)
        result = 31 * result + (code?.hashCode() ?: 0)
        result = 31 * result + (use?.hashCode() ?: 0)
        result = 31 * result + (at?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }

}
