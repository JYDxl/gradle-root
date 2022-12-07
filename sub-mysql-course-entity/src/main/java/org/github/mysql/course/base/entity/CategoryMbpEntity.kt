@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 分类
 *
 * @author JYD_XL
 */
@TableName("category")
open class CategoryMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 父id */
    @TableField("parent")
    open var parent: String? = null

    /** 名称 */
    @TableField("name")
    open var name: String? = null

    /** 顺序 */
    @TableField("sort")
    open var sort: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PARENT : String = "parent"

        const val NAME : String = "name"

        const val SORT : String = "sort"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
