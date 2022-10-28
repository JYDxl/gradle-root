package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.*
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.github.base.Entity
import java.time.LocalDateTime

/**
 * 用户个人信息表
 *
 * @author JYD_XL
 */
@TableName("tb_user_info")
@ApiModel(value = "UserInfoEntity对象", description = "用户个人信息表")
open class UserInfoEntity: Entity() {

  /** 主键 */
  @ApiModelProperty(value = "主键")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  open var id: Long? = null

  /** 邮箱地址 */
  @ApiModelProperty(value = "邮箱地址")
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
  @TableField(value = "created_at", fill = FieldFill.INSERT)
  open var createdTime: LocalDateTime? = null

  /** 更新时间 */
  @ApiModelProperty(value = "更新时间")
  @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
  open var updatedTime: LocalDateTime? = null

  /** 是否禁用 0：未禁用 1：已禁用 */
  @ApiModelProperty(value = "是否禁用 0：未禁用 1：已禁用")
  @TableField("is_disabled")
  open var isDisabled: Int? = null

  companion object {

    private const val serialVersionUID = 1L

    const val ID: String = "id"

    const val EMAIL: String = "email"

    const val NICKNAME: String = "nickname"

    const val AVATAR: String = "avatar"

    const val INTRO: String = "intro"

    const val WEB_SITE: String = "web_site"

    const val CREATED_AT: String = "created_at"

    const val UPDATED_AT: String = "updated_at"

    const val IS_DISABLED: String = "is_disabled"

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
      ", createdTime=" + createdTime +
      ", updatedTime=" + updatedTime +
      ", isDisabled=" + isDisabled +
      "}"
  }

}
