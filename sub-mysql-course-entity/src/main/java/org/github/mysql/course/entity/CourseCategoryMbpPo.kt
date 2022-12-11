@file:Suppress("UnusedImport", "unused")

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

        const val COURSE_ID : String = "course_id"

        const val CATEGORY_ID : String = "category_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
