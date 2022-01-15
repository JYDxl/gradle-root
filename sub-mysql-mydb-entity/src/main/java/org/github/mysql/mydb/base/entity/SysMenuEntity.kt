@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 菜单表
 *
 * @author JYD_XL
 */
@TableName("sys_menu")
@ApiModel(value = "SysMenuEntity对象", description = "菜单表")
open class SysMenuEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    open var menuId: Long? = null

    /** 父菜单ID */
    @ApiModelProperty(value = "父菜单ID")
    @TableField("parent_id")
    open var parentId: Long? = null

    /** 菜单名称 */
    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    open var name: String? = null

    /** 菜单URL */
    @ApiModelProperty(value = "菜单URL")
    @TableField("url")
    open var url: String? = null

    /** 授权(多个用逗号分隔，如：user:list,user:create) */
    @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
    @TableField("perms")
    open var perms: String? = null

    /** 类型   0：目录   1：菜单   2：按钮 */
    @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
    @TableField("type")
    open var type: Int? = null

    /** 菜单图标 */
    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    open var icon: String? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    open var orderNum: Int? = null

    /** 是否启用（0：禁用 1：启用） */
    @ApiModelProperty(value = "是否启用（0：禁用 1：启用）")
    @TableField("enabled")
    open var enabled: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val MENU_ID : String = "menu_id"

        const val PARENT_ID : String = "parent_id"

        const val NAME : String = "name"

        const val URL : String = "url"

        const val PERMS : String = "perms"

        const val TYPE : String = "type"

        const val ICON : String = "icon"

        const val ORDER_NUM : String = "order_num"

        const val ENABLED : String = "enabled"

    }

    override fun pkVal(): Serializable? {
        return menuId
    }

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
