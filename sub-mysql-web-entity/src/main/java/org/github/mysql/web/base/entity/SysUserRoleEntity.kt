@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户与角色对应关系
 *
 * @author JYD_XL
 */
@TableName("sys_user_role")
@ApiModel(value = "SysUserRoleEntity对象", description = "用户与角色对应关系")
open class SysUserRoleEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Long? = null

    /** 角色ID */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    open var roleId: Long? = null

    override fun toString(): String {
        return "SysUserRoleEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}"
    }

}
