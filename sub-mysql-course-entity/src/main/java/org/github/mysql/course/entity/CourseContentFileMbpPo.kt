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
 * 课程内容文件
 *
 * @author JYD_XL
 */
@TableName("course_content_file")
@ApiModel("课程内容文件")
open class CourseContentFileMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("课程id")
    @TableField("course_id")
    open var courseId: String? = null

    @ApiModelProperty("地址")
    @TableField("url")
    open var url: String? = null

    @ApiModelProperty("文件名")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("大小|字节b")
    @TableField("size")
    open var size: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val COURSE_ID : String = "course_id"

        const val URL : String = "url"

        const val NAME : String = "name"

        const val SIZE : String = "size"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CourseContentFileMbpPo) return false
        if (id != other.id) return false
        if (courseId != other.courseId) return false
        if (url != other.url) return false
        if (name != other.name) return false
        if (size != other.size) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (courseId?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (size?.hashCode() ?: 0)
        return result
    }

}
