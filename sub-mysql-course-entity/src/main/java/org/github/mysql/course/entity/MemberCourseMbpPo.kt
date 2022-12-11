@file:Suppress("UnusedImport", "unused")

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

        const val MEMBER_ID : String = "member_id"

        const val COURSE_ID : String = "course_id"

        const val AT : String = "at"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
