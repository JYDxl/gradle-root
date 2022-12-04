@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 角色资源关联
 *
 * @author JYD_XL
 */
@TableName("role_resource")
open class RoleResourceEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 角色|id */
    @TableField("role_id")
    open var roleId: String? = null

    /** 资源|id */
    @TableField("resource_id")
    open var resourceId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_ID : String = "role_id"

        const val RESOURCE_ID : String = "resource_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
