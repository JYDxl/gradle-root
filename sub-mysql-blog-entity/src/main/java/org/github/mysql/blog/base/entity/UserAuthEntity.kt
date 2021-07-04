package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_user_auth")
@ApiModel(value = "UserAuthEntity对象", description = "")
open class UserAuthEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户信息id */
    @ApiModelProperty(value = "用户信息id")
    @TableField("user_info_id")
    open var userInfoId: Int? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var username: String? = null

    /** 密码 */
    @ApiModelProperty(value = "密码")
    open var password: String? = null

    /** 登录类型 */
    @ApiModelProperty(value = "登录类型")
    @TableField("login_type")
    open var loginType: Boolean? = null

    /** 用户登录ip */
    @ApiModelProperty(value = "用户登录ip")
    @TableField("ip_addr")
    open var ipAddr: String? = null

    /** ip来源 */
    @ApiModelProperty(value = "ip来源")
    @TableField("ip_source")
    open var ipSource: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 上次登录时间 */
    @ApiModelProperty(value = "上次登录时间")
    @TableField("last_login_time")
    open var lastLoginTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_INFO_ID : String = "user_info_id"

        const val USERNAME : String = "username"

        const val PASSWORD : String = "password"

        const val LOGIN_TYPE : String = "login_type"

        const val IP_ADDR : String = "ip_addr"

        const val IP_SOURCE : String = "ip_source"

        const val CREATE_TIME : String = "create_time"

        const val LAST_LOGIN_TIME : String = "last_login_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "UserAuthEntity{" +
        "id=" + id +
        ", userInfoId=" + userInfoId +
        ", username=" + username +
        ", password=" + password +
        ", loginType=" + loginType +
        ", ipAddr=" + ipAddr +
        ", ipSource=" + ipSource +
        ", createTime=" + createTime +
        ", lastLoginTime=" + lastLoginTime +
        "}"
    }

}
