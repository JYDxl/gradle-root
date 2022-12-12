@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 角色用户关联
 *
 * @author JYD_XL
 */
@TableName("role_user")
@ApiModel("角色用户关联")
open class RoleUserMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("角色|id")
    @TableField("role_id")
    open var roleId: String? = null

    @ApiModelProperty("用户|id")
    @TableField("user_id")
    open var userId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val USER_ID : String = "user_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RoleUserMbpPo) return false
        if (id != other.id) return false
        if (role_id != other.role_id) return false
        if (user_id != other.user_id) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (role_id?.hashCode() ?: 0)
        result = 31 * result + (user_id?.hashCode() ?: 0)
        return result
    }

}
