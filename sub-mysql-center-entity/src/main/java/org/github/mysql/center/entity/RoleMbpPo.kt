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
 * 角色
 *
 * @author JYD_XL
 */
@TableName("role")
@ApiModel("角色")
open class RoleMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("角色")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("描述")
    @TableField("desc")
    open var desc: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val DESC : String = "desc"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RoleMbpPo) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (desc != other.desc) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (desc?.hashCode() ?: 0)
        return result
    }

}
