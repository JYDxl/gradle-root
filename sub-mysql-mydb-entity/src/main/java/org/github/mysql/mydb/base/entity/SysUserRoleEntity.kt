@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户-角色关系表
 *
 * @author JYD_XL
 */
@TableName("sys_user_role")
@ApiModel(value = "SysUserRoleEntity对象", description = "用户-角色关系表")
open class SysUserRoleEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Long? = null

    /** 角色id */
    @ApiModelProperty(value = "角色id")
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
