package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 管理员用户信息表
 *
 * @author JYD_XL
 */
@TableName("ad_user")
@ApiModel(value = "AdUserEntity对象", description = "管理员用户信息表")
open class AdUserEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 登录用户名 */
    @ApiModelProperty(value = "登录用户名")
    open var name: String? = null

    /** 登录密码 */
    @ApiModelProperty(value = "登录密码")
    open var password: String? = null

    /** 盐 */
    @ApiModelProperty(value = "盐")
    open var salt: String? = null

    /** 昵称 */
    @ApiModelProperty(value = "昵称")
    open var nickname: String? = null

    /** 头像 */
    @ApiModelProperty(value = "头像")
    open var image: String? = null

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    open var phone: String? = null

    /** 状态	            0 暂时不可用	            1 永久不可用	            9 正常可用 */
    @ApiModelProperty(value = "状态	            0 暂时不可用	            1 永久不可用	            9 正常可用")
    open var status: Int? = null

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    open var email: String? = null

    /** 最后一次登录时间 */
    @ApiModelProperty(value = "最后一次登录时间")
    @TableField("login_time")
    open var loginTime: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val PASSWORD : String = "password"

        const val SALT : String = "salt"

        const val NICKNAME : String = "nickname"

        const val IMAGE : String = "image"

        const val PHONE : String = "phone"

        const val STATUS : String = "status"

        const val EMAIL : String = "email"

        const val LOGIN_TIME : String = "login_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdUserEntity{" +
        "id=" + id +
        ", name=" + name +
        ", password=" + password +
        ", salt=" + salt +
        ", nickname=" + nickname +
        ", image=" + image +
        ", phone=" + phone +
        ", status=" + status +
        ", email=" + email +
        ", loginTime=" + loginTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
