package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_role_menu")
@ApiModel(value = "RoleMenuEntity对象", description = "")
open class RoleMenuEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 角色id */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    open var roleId: Int? = null

    /** 菜单id */
    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    open var menuId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val MENU_ID : String = "menu_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "RoleMenuEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}"
    }

}
