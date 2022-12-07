@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 讲师
 *
 * @author JYD_XL
 */
@TableName("teacher")
open class TeacherMbpEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 姓名 */
    @TableField("name")
    open var name: String? = null

    /** 昵称 */
    @TableField("nickname")
    open var nickname: String? = null

    /** 头像 */
    @TableField("image")
    open var image: String? = null

    /** 职位 */
    @TableField("position")
    open var position: String? = null

    /** 座右铭 */
    @TableField("motto")
    open var motto: String? = null

    /** 简介 */
    @TableField("intro")
    open var intro: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val NICKNAME : String = "nickname"

        const val IMAGE : String = "image"

        const val POSITION : String = "position"

        const val MOTTO : String = "motto"

        const val INTRO : String = "intro"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
