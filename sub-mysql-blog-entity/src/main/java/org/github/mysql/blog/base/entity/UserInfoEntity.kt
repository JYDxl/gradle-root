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
@TableName("tb_user_info")
@ApiModel(value = "UserInfoEntity对象", description = "")
open class UserInfoEntity : Entity() {

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 邮箱号 */
    @ApiModelProperty(value = "邮箱号")
    open var email: String? = null

    /** 用户昵称 */
    @ApiModelProperty(value = "用户昵称")
    open var nickname: String? = null

    /** 用户头像 */
    @ApiModelProperty(value = "用户头像")
    open var avatar: String? = null

    /** 用户简介 */
    @ApiModelProperty(value = "用户简介")
    open var intro: String? = null

    /** 个人网站 */
    @ApiModelProperty(value = "个人网站")
    @TableField("web_site")
    open var webSite: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 是否禁用 */
    @ApiModelProperty(value = "是否禁用")
    @TableField("is_disable")
    open var isDisable: Boolean? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val EMAIL : String = "email"

        const val NICKNAME : String = "nickname"

        const val AVATAR : String = "avatar"

        const val INTRO : String = "intro"

        const val WEB_SITE : String = "web_site"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DISABLE : String = "is_disable"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "UserInfoEntity{" +
        "id=" + id +
        ", email=" + email +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", intro=" + intro +
        ", webSite=" + webSite +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDisable=" + isDisable +
        "}"
    }

}
