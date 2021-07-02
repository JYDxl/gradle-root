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
 * 管理员角色信息表
 *
 * @author JYD_XL
 */
@TableName("ad_user_role")
@ApiModel(value = "AdUserRoleEntity对象", description = "管理员角色信息表")
open class AdUserRoleEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 角色ID */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    open var roleId: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val USER_ID : String = "user_id"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdUserRoleEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", userId=" + userId +
        ", createdTime=" + createdTime +
        "}"
    }

}
