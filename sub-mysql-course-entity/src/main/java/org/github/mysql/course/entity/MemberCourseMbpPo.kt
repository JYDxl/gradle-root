@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.course.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 会员课程报名
 *
 * @author JYD_XL
 */
@TableName("member_course")
@ApiModel("会员课程报名")
open class MemberCourseMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("会员id")
    @TableField("member_id")
    open var memberId: String? = null

    @ApiModelProperty("课程id")
    @TableField("course_id")
    open var courseId: String? = null

    @ApiModelProperty("报名时间")
    @TableField("at")
    open var at: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val MEMBER_ID : String = "member_id"

        const val MEMBER_ID_PROP : String = "memberId"

        const val COURSE_ID : String = "course_id"

        const val COURSE_ID_PROP : String = "courseId"

        const val AT : String = "at"

        const val AT_PROP : String = "at"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MemberCourseMbpPo) return false
        if (id != other.id) return false
        if (memberId != other.memberId) return false
        if (courseId != other.courseId) return false
        if (at != other.at) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (memberId?.hashCode() ?: 0)
        result = 31 * result + (courseId?.hashCode() ?: 0)
        result = 31 * result + (at?.hashCode() ?: 0)
        return result
    }

}
