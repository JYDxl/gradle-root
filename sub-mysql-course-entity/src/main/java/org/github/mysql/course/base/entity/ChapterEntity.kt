@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity

/**
 * 大章
 *
 * @author JYD_XL
 */
@TableName("chapter")
open class ChapterEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 课程id */
    @TableField("course_id")
    open var courseId: String? = null

    /** 名称 */
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

}
