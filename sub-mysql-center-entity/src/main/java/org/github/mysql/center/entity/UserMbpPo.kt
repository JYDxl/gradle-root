@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 用户
 *
 * @author JYD_XL
 */
@TableName("user")
@ApiModel("用户")
open class UserMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("登陆名")
    @TableField("login_name")
    open var loginName: String? = null

    @ApiModelProperty("昵称")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("密码")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserMbpPo) return false
        if (id != other.id) return false
        if (login_name != other.login_name) return false
        if (name != other.name) return false
        if (password != other.password) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (login_name?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (password?.hashCode() ?: 0)
        return result
    }

}
