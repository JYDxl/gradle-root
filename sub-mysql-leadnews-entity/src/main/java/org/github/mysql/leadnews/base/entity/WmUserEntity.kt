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
 * 自媒体用户信息表
 *
 * @author JYD_XL
 */
@TableName("wm_user")
@ApiModel(value = "WmUserEntity对象", description = "自媒体用户信息表")
open class WmUserEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    @TableField("ap_user_id")
    open var apUserId: Int? = null

    @TableField("ap_author_id")
    open var apAuthorId: Int? = null

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

    /** 归属地 */
    @ApiModelProperty(value = "归属地")
    open var location: String? = null

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    open var phone: String? = null

    /** 状态	            0 暂时不可用	            1 永久不可用	            9 正常可用 */
    @ApiModelProperty(value = "状态	            0 暂时不可用	            1 永久不可用	            9 正常可用")
    open var status: Int? = null

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    open var email: String? = null

    /** 账号类型	            0 个人 	            1 企业	            2 子账号 */
    @ApiModelProperty(value = "账号类型	            0 个人 	            1 企业	            2 子账号")
    open var type: Int? = null

    /** 运营评分 */
    @ApiModelProperty(value = "运营评分")
    open var score: Int? = null

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

        const val AP_USER_ID : String = "ap_user_id"

        const val AP_AUTHOR_ID : String = "ap_author_id"

        const val NAME : String = "name"

        const val PASSWORD : String = "password"

        const val SALT : String = "salt"

        const val NICKNAME : String = "nickname"

        const val IMAGE : String = "image"

        const val LOCATION : String = "location"

        const val PHONE : String = "phone"

        const val STATUS : String = "status"

        const val EMAIL : String = "email"

        const val TYPE : String = "type"

        const val SCORE : String = "score"

        const val LOGIN_TIME : String = "login_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmUserEntity{" +
        "id=" + id +
        ", apUserId=" + apUserId +
        ", apAuthorId=" + apAuthorId +
        ", name=" + name +
        ", password=" + password +
        ", salt=" + salt +
        ", nickname=" + nickname +
        ", image=" + image +
        ", location=" + location +
        ", phone=" + phone +
        ", status=" + status +
        ", email=" + email +
        ", type=" + type +
        ", score=" + score +
        ", loginTime=" + loginTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
