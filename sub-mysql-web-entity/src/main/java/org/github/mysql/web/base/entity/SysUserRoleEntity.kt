@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户与角色对应关系
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@TableName("sys_user_role")
@ApiModel(value="SysUserRoleEntity对象", description="用户与角色对应关系")
open class SysUserRoleEntity : IEntity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Long? = null

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
