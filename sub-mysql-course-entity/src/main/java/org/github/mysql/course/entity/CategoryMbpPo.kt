@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.course.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 分类
 *
 * @author JYD_XL
 */
@TableName("category")
@ApiModel("分类")
open class CategoryMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("父id")
    @TableField("parent")
    open var parent: String? = null

    @ApiModelProperty("名称")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("顺序")
    @TableField("sort")
    open var sort: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val PARENT : String = "parent"

        const val PARENT_PROP : String = "parent"

        const val NAME : String = "name"

        const val NAME_PROP : String = "name"

        const val SORT : String = "sort"

        const val SORT_PROP : String = "sort"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CategoryMbpPo) return false
        if (id != other.id) return false
        if (parent != other.parent) return false
        if (name != other.name) return false
        if (sort != other.sort) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (parent?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (sort?.hashCode() ?: 0)
        return result
    }

}
