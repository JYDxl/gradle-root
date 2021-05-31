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
 * 菜单管理
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@TableName("sys_menu")
@ApiModel(value = "SysMenuEntity对象", description = "菜单管理")
open class SysMenuEntity : Entity() {

    @TableId(value = "menu_id", type = IdType.AUTO)
    open var menuId: Long? = null

    /** 父菜单ID，一级菜单为0 */
    @ApiModelProperty(value = "父菜单ID，一级菜单为0")
    @TableField("parent_id")
    open var parentId: Long? = null

    /** 菜单名称 */
    @ApiModelProperty(value = "菜单名称")
    open var name: String? = null

    /** 菜单URL */
    @ApiModelProperty(value = "菜单URL")
    open var url: String? = null

    /** 授权(多个用逗号分隔，如：user:list,user:create) */
    @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
    open var perms: String? = null

    /** 类型   0：目录   1：菜单   2：按钮 */
    @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
    open var type: Int? = null

    /** 菜单图标 */
    @ApiModelProperty(value = "菜单图标")
    open var icon: String? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    open var orderNum: Int? = null

    /** 是否启用（0：启用 1：禁用） */
    @ApiModelProperty(value = "是否启用（0：启用 1：禁用）")
    open var enabled: Int? = null

    override fun toString(): String {
        return "SysMenuEntity{" +
        "menuId=" + menuId +
        ", parentId=" + parentId +
        ", name=" + name +
        ", url=" + url +
        ", perms=" + perms +
        ", type=" + type +
        ", icon=" + icon +
        ", orderNum=" + orderNum +
        ", enabled=" + enabled +
        "}"
    }

}
