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
 * 用户角色组管理
 *
 * @author JYD_XL
 */
@TableName("t_sys_user_role_group_rela")
@ApiModel(value = "SysUserRoleGroupRelaEntity对象", description = "用户角色组管理")
open class SysUserRoleGroupRelaEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Long? = null

    /** 角色组ID */
    @ApiModelProperty(value = "角色组ID")
    @TableField("role_group_id")
    open var roleGroupId: Long? = null

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

        const val USER_ID : String = "user_id"

        const val ROLE_GROUP_ID : String = "role_group_id"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysUserRoleGroupRelaEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleGroupId=" + roleGroupId +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        "}"
    }

}
