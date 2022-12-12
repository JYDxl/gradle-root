@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.course.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 课程
 *
 * @author JYD_XL
 */
@TableName("course")
@ApiModel("课程")
open class CourseMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("名称")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("概述")
    @TableField("summary")
    open var summary: String? = null

    @ApiModelProperty("时长|单位秒")
    @TableField("time")
    open var time: Int? = null

    @ApiModelProperty("价格（元）")
    @TableField("price")
    open var price: BigDecimal? = null

    @ApiModelProperty("封面")
    @TableField("image")
    open var image: String? = null

    @ApiModelProperty("级别|枚举[CourseLevelEnum]：ONE(\"1\", \"初级\"),TWO(\"2\", \"中级\"),THREE(\"3\", \"高级\")")
    @TableField("level")
    open var level: String? = null

    @ApiModelProperty("收费|枚举[CourseChargeEnum]：CHARGE(\"C\", \"收费\"),FREE(\"F\", \"免费\")")
    @TableField("charge")
    open var charge: String? = null

    @ApiModelProperty("状态|枚举[CourseStatusEnum]：PUBLISH(\"P\", \"发布\"),DRAFT(\"D\", \"草稿\")")
    @TableField("status")
    open var status: String? = null

    @ApiModelProperty("报名数")
    @TableField("enroll")
    open var enroll: Int? = null

    @ApiModelProperty("顺序")
    @TableField("sort")
    open var sort: Int? = null

    @ApiModelProperty("创建时间")
    @TableField("created_at")
    open var createdAt: LocalDateTime? = null

    @ApiModelProperty("修改时间")
    @TableField("updated_at")
    open var updatedAt: LocalDateTime? = null

    @ApiModelProperty("讲师|teacher.id")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CourseMbpPo) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (summary != other.summary) return false
        if (time != other.time) return false
        if (price != other.price) return false
        if (image != other.image) return false
        if (level != other.level) return false
        if (charge != other.charge) return false
        if (status != other.status) return false
        if (enroll != other.enroll) return false
        if (sort != other.sort) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false
        if (teacherId != other.teacherId) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (summary?.hashCode() ?: 0)
        result = 31 * result + (time?.hashCode() ?: 0)
        result = 31 * result + (price?.hashCode() ?: 0)
        result = 31 * result + (image?.hashCode() ?: 0)
        result = 31 * result + (level?.hashCode() ?: 0)
        result = 31 * result + (charge?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (enroll?.hashCode() ?: 0)
        result = 31 * result + (sort?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (teacherId?.hashCode() ?: 0)
        return result
    }

}
