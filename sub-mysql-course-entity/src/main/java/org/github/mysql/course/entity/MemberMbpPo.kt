@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.course.entity

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
 * 会员
 *
 * @author JYD_XL
 */
@TableName("member")
@ApiModel("会员")
open class MemberMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("手机号")
    @TableField("mobile")
    open var mobile: String? = null

    @ApiModelProperty("密码")
    @TableField("password")
    open var password: String? = null

    @ApiModelProperty("昵称")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("头像url")
    @TableField("photo")
    open var photo: String? = null

    @ApiModelProperty("注册时间")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MemberMbpPo) return false
        if (id != other.id) return false
        if (mobile != other.mobile) return false
        if (password != other.password) return false
        if (name != other.name) return false
        if (photo != other.photo) return false
        if (registerTime != other.registerTime) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (mobile?.hashCode() ?: 0)
        result = 31 * result + (password?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (photo?.hashCode() ?: 0)
        result = 31 * result + (registerTime?.hashCode() ?: 0)
        return result
    }

}
