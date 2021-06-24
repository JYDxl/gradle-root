package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 用户表
 *
 * @author JYD_XL
 */
@TableName("sys_user")
@ApiModel(value = "SysUserEntity对象", description = "用户表")
open class SysUserEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var username: String? = null

    /** 密码 */
    @ApiModelProperty(value = "密码")
    open var password: String? = null

    /** 盐 */
    @ApiModelProperty(value = "盐")
    open var salt: String? = null

    /** 启用状态 0：禁用 1：正常 */
    @ApiModelProperty(value = "启用状态 0：禁用 1：正常")
    open var enabled: Int? = null

    /** 昵称 */
    @ApiModelProperty(value = "昵称")
    open var nickname: String? = null

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    open var email: String? = null

    /** 手机号 */
    @ApiModelProperty(value = "手机号")
    open var mobile: String? = null

    /** 创建人id */
    @ApiModelProperty(value = "创建人id")
    @TableField("creator_id")
    open var creatorId: Long? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 修改人id */
    @ApiModelProperty(value = "修改人id")
    @TableField("modifier_id")
    open var modifierId: Long? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    open var modifyTime: LocalDateTime? = null

    /** 删除状态 0：未删除 1：已删除 */
    @ApiModelProperty(value = "删除状态 0：未删除 1：已删除")
    open var deleted: Int? = null

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysUserEntity{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", enabled=" + enabled +
        ", nickname=" + nickname +
        ", email=" + email +
        ", mobile=" + mobile +
        ", creatorId=" + creatorId +
        ", createTime=" + createTime +
        ", modifierId=" + modifierId +
        ", modifyTime=" + modifyTime +
        ", deleted=" + deleted +
        "}"
    }

}
