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
 * 课程内容
 *
 * @author JYD_XL
 */
@TableName("course_content")
@ApiModel("课程内容")
open class CourseContentMbpPo : Entity() {

    @ApiModelProperty("课程id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("课程内容")
    @TableField("content")
    open var content: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val CONTENT : String = "content"

        const val CONTENT_PROP : String = "content"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CourseContentMbpPo) return false
        if (id != other.id) return false
        if (content != other.content) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (content?.hashCode() ?: 0)
        return result
    }

}
