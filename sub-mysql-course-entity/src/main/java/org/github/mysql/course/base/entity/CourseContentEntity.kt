@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 课程内容
 *
 * @author JYD_XL
 */
@TableName("course_content")
open class CourseContentEntity : Entity() {

    /** 课程id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 课程内容 */
    @TableField("content")
    open var content: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CONTENT : String = "content"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
