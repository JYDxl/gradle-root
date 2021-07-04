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
@TableName("tb_user_role")
@ApiModel(value = "UserRoleEntity对象", description = "")
open class UserRoleEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Int? = null

    /** 角色id */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    open var roleId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val ROLE_ID : String = "role_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "UserRoleEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}"
    }

}
