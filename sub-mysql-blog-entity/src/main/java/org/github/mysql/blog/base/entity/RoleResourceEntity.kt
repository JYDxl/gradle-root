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
@TableName("tb_role_resource")
@ApiModel(value = "RoleResourceEntity对象", description = "")
open class RoleResourceEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 角色id */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    open var roleId: Int? = null

    /** 权限id */
    @ApiModelProperty(value = "权限id")
    @TableField("resource_id")
    open var resourceId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val RESOURCE_ID : String = "resource_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "RoleResourceEntity{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", resourceId=" + resourceId +
        "}"
    }

}
