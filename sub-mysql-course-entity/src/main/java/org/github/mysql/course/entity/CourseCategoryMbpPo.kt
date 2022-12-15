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
 * 课程分类
 *
 * @author JYD_XL
 */
@TableName("course_category")
@ApiModel("课程分类")
open class CourseCategoryMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("课程|course.id")
    @TableField("course_id")
    open var courseId: String? = null

    @ApiModelProperty("分类|course.id")
    @TableField("category_id")
    open var categoryId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val COURSE_ID : String = "course_id"

        const val COURSE_ID_PROP : String = "courseId"

        const val CATEGORY_ID : String = "category_id"

        const val CATEGORY_ID_PROP : String = "categoryId"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CourseCategoryMbpPo) return false
        if (id != other.id) return false
        if (courseId != other.courseId) return false
        if (categoryId != other.categoryId) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (courseId?.hashCode() ?: 0)
        result = 31 * result + (categoryId?.hashCode() ?: 0)
        return result
    }

}
