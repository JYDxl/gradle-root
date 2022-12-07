@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 课程内容文件
 *
 * @author JYD_XL
 */
@TableName("course_content_file")
open class CourseContentFileMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 课程id */
    @TableField("course_id")
    open var courseId: String? = null

    /** 地址 */
    @TableField("url")
    open var url: String? = null

    /** 文件名 */
    @TableField("name")
    open var name: String? = null

    /** 大小|字节b */
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

}
