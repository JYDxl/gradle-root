@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 角色菜单管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_role_menu_rela")
@ApiModel(value = "SysRoleMenuRelaEntity对象", description = "角色菜单管理")
open class SysRoleMenuRelaEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 菜单ID */
    @ApiModelProperty(value = "菜单ID")
    @TableField("menu_id")
    open var menuId: Long? = null

    /** 角色ID */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    open var roleId: Long? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    @TableField("user_create")
    open var userCreate: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val MENU_ID : String = "menu_id"

        const val ROLE_ID : String = "role_id"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysRoleMenuRelaEntity{" +
        "id=" + id +
        ", menuId=" + menuId +
        ", roleId=" + roleId +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
