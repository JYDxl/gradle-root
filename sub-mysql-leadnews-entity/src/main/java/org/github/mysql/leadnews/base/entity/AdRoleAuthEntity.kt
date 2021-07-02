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
 * 角色权限信息表
 *
 * @author JYD_XL
 */
@TableName("ad_role_auth")
@ApiModel(value = "AdRoleAuthEntity对象", description = "角色权限信息表")
open class AdRoleAuthEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 角色ID */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    open var roleId: Int? = null

    /** 资源类型	            0 菜单	            1 功能 */
    @ApiModelProperty(value = "资源类型	            0 菜单	            1 功能")
    open var type: Int? = null

    /** 资源ID */
    @ApiModelProperty(value = "资源ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val TYPE : String = "type"

        const val ENTRY_ID : String = "entry_id"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdRoleAuthEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", type=" + type +
        ", entryId=" + entryId +
        ", createdTime=" + createdTime +
        "}"
    }

}
