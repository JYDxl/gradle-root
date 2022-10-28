package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.*
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.github.base.Entity
import java.time.LocalDateTime

/**
 * 用户登录信息表
 *
 * @author JYD_XL
 */
@TableName("tb_user_auth")
@ApiModel(value = "UserAuthEntity对象", description = "用户登录信息表")
open class UserAuthEntity: Entity() {

  /** 主键 */
  @ApiModelProperty(value = "主键")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  open var id: Long? = null

  /** 用户个人信息id */
  @ApiModelProperty(value = "用户个人信息id")
  @TableField("user_info_id")
  open var userInfoId: Long? = null

  /** 用户名 */
  @ApiModelProperty(value = "用户名")
  open var username: String? = null

  /** 密码 */
  @ApiModelProperty(value = "密码")
  open var password: String? = null

  /** 登录类型 */
  @ApiModelProperty(value = "登录类型")
  @TableField("login_type")
  open var loginType: Int? = null

  /** 用户登录ip */
  @ApiModelProperty(value = "用户登录ip")
  @TableField("ip_addr")
  open var ipAddr: String? = null

  /** 用户登录ip来源 */
  @ApiModelProperty(value = "用户登录ip来源")
  @TableField("ip_source")
  open var ipSource: String? = null

  /** 创建时间 */
  @ApiModelProperty(value = "创建时间")
  @TableField(value = "created_at", fill = FieldFill.INSERT)
  open var createdTime: LocalDateTime? = null

  /** 上次登录时间 */
  @ApiModelProperty(value = "上次登录时间")
  @TableField("last_login_at")
  open var lastLoginAt: LocalDateTime? = null

  companion object {

    private const val serialVersionUID = 1L

    const val ID: String = "id"

    const val USER_INFO_ID: String = "user_info_id"

    const val USERNAME: String = "username"

    const val PASSWORD: String = "password"

    const val LOGIN_TYPE: String = "login_type"

    const val IP_ADDR: String = "ip_addr"

    const val IP_SOURCE: String = "ip_source"

    const val CREATED_AT: String = "created_at"

    const val LAST_LOGIN_AT: String = "last_login_at"

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
      ", createdTime=" + createdTime +
      ", lastLoginAt=" + lastLoginAt +
      "}"
  }

}
