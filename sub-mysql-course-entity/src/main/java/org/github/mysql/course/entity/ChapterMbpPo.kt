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
 * 大章
 *
 * @author JYD_XL
 */
@TableName("chapter")
@ApiModel("大章")
open class ChapterMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("课程id")
    @TableField("course_id")
    open var courseId: String? = null

    @ApiModelProperty("名称")
    @TableField("name")
    open var name: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val COURSE_ID : String = "course_id"

        const val NAME : String = "name"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChapterMbpPo) return false
        if (id != other.id) return false
        if (course_id != other.course_id) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (course_id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

}
