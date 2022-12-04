@file:Suppress("UnusedImport", "unused")

package org.github.mysql.course.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 课程
 *
 * @author JYD_XL
 */
@TableName("course")
open class CourseEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 名称 */
    @TableField("name")
    open var name: String? = null

    /** 概述 */
    @TableField("summary")
    open var summary: String? = null

    /** 时长|单位秒 */
    @TableField("time")
    open var time: Int? = null

    /** 价格（元） */
    @TableField("price")
    open var price: BigDecimal? = null

    /** 封面 */
    @TableField("image")
    open var image: String? = null

    /** 级别|枚举[CourseLevelEnum]：ONE("1", "初级"),TWO("2", "中级"),THREE("3", "高级") */
    @TableField("level")
    open var level: String? = null

    /** 收费|枚举[CourseChargeEnum]：CHARGE("C", "收费"),FREE("F", "免费") */
    @TableField("charge")
    open var charge: String? = null

    /** 状态|枚举[CourseStatusEnum]：PUBLISH("P", "发布"),DRAFT("D", "草稿") */
    @TableField("status")
    open var status: String? = null

    /** 报名数 */
    @TableField("enroll")
    open var enroll: Int? = null

    /** 顺序 */
    @TableField("sort")
    open var sort: Int? = null

    /** 创建时间 */
    @TableField("created_at")
    open var createdAt: LocalDateTime? = null

    /** 修改时间 */
    @TableField("updated_at")
    open var updatedAt: LocalDateTime? = null

    /** 讲师|teacher.id */
    @TableField("teacher_id")
    open var teacherId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val SUMMARY : String = "summary"

        const val TIME : String = "time"

        const val PRICE : String = "price"

        const val IMAGE : String = "image"

        const val LEVEL : String = "level"

        const val CHARGE : String = "charge"

        const val STATUS : String = "status"

        const val ENROLL : String = "enroll"

        const val SORT : String = "sort"

        const val CREATED_AT : String = "created_at"

        const val UPDATED_AT : String = "updated_at"

        const val TEACHER_ID : String = "teacher_id"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
