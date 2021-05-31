@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统用户
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@TableName("sys_user")
@ApiModel(value = "SysUserEntity对象", description = "系统用户")
open class SysUserEntity : Entity() {

    @TableId(value = "user_id", type = IdType.AUTO)
    open var userId: Long? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var username: String? = null

    /** 密码 */
    @ApiModelProperty(value = "密码")
    open var password: String? = null

    /** salt */
    @ApiModelProperty(value = "salt")
    open var salt: String? = null

    /** 状态  0：禁用 1：正常 */
    @ApiModelProperty(value = "状态  0：禁用 1：正常")
    open var status: Int? = null

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    open var email: String? = null

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    open var mobile: String? = null

    /** 创建者ID */
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_user_id")
    open var createUserId: Long? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 0：未删除 1：已删除 */
    @ApiModelProperty(value = "0：未删除 1：已删除")
    open var deleted: Int? = null

    override fun toString(): String {
        return "SysUserEntity{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", status=" + status +
        ", email=" + email +
        ", mobile=" + mobile +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", deleted=" + deleted +
        "}"
    }

}
