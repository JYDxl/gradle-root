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
 * 用户
 *
 * @author JYD_XL
 */
@TableName("t_sys_user")
@ApiModel("用户")
open class SysUserMbpPo : Entity() {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    @ApiModelProperty("登录用户名")
    @TableField("user_name")
    open var userName: String? = null

    @ApiModelProperty("登录密码")
    @TableField("user_pwd")
    open var userPwd: String? = null

    @ApiModelProperty("加密方式")
    @TableField("secret_algorithm")
    open var secretAlgorithm: String? = null

    @ApiModelProperty("秘钥")
    @TableField("secret_key")
    open var secretKey: ByteArray? = null

    @ApiModelProperty("昵称")
    @TableField("nice_name")
    open var niceName: String? = null

    @ApiModelProperty("创建人")
    @TableField("creator_name")
    open var creatorName: String? = null

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    @ApiModelProperty("修改人")
    @TableField("updater_name")
    open var updaterName: String? = null

    @ApiModelProperty("修改时间")
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_NAME : String = "user_name"

        const val USER_PWD : String = "user_pwd"

        const val SECRET_ALGORITHM : String = "secret_algorithm"

        const val SECRET_KEY : String = "secret_key"

        const val NICE_NAME : String = "nice_name"

        const val CREATOR_NAME : String = "creator_name"

        const val CREATED_TIME : String = "created_time"

        const val UPDATER_NAME : String = "updater_name"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SysUserMbpPo) return false
        if (id != other.id) return false
        if (userName != other.userName) return false
        if (userPwd != other.userPwd) return false
        if (secretAlgorithm != other.secretAlgorithm) return false
        if (secretKey != other.secretKey) return false
        if (niceName != other.niceName) return false
        if (creatorName != other.creatorName) return false
        if (createdTime != other.createdTime) return false
        if (updaterName != other.updaterName) return false
        if (updatedTime != other.updatedTime) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (userName?.hashCode() ?: 0)
        result = 31 * result + (userPwd?.hashCode() ?: 0)
        result = 31 * result + (secretAlgorithm?.hashCode() ?: 0)
        result = 31 * result + (secretKey?.hashCode() ?: 0)
        result = 31 * result + (niceName?.hashCode() ?: 0)
        result = 31 * result + (creatorName?.hashCode() ?: 0)
        result = 31 * result + (createdTime?.hashCode() ?: 0)
        result = 31 * result + (updaterName?.hashCode() ?: 0)
        result = 31 * result + (updatedTime?.hashCode() ?: 0)
        return result
    }

}
