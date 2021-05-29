@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@TableName("sys_role_menu")
@ApiModel(value="SysRoleMenuEntity对象", description="角色与菜单对应关系")
open class SysRoleMenuEntity : IEntity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    open var roleId: Long? = null

    @ApiModelProperty(value = "菜单ID")
    @TableField("menu_id")
    open var menuId: Long? = null

    override fun toString(): String {
        return "SysRoleMenuEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}"
    }
}
