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
 * 小节
 *
 * @author JYD_XL
 */
@TableName("section")
@ApiModel("小节")
open class SectionMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("标题")
    @TableField("title")
    open var title: String? = null

    @ApiModelProperty("课程|course.id")
    @TableField("course_id")
    open var courseId: String? = null

    @ApiModelProperty("大章|chapter.id")
    @TableField("chapter_id")
    open var chapterId: String? = null

    @ApiModelProperty("视频")
    @TableField("video")
    open var video: String? = null

    @ApiModelProperty("时长|单位秒")
    @TableField("time")
    open var time: Int? = null

    @ApiModelProperty("收费|C 收费；F 免费")
    @TableField("charge")
    open var charge: String? = null

    @ApiModelProperty("顺序")
    @TableField("sort")
    open var sort: Int? = null

    @ApiModelProperty("创建时间")
    @TableField("created_at")
    open var createdAt: LocalDateTime? = null

    @ApiModelProperty("修改时间")
    @TableField("updated_at")
    open var updatedAt: LocalDateTime? = null

    @ApiModelProperty("vod|阿里云vod")
    @TableField("vod")
    open var vod: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val TITLE : String = "title"

        const val TITLE_PROP : String = "title"

        const val COURSE_ID : String = "course_id"

        const val COURSE_ID_PROP : String = "courseId"

        const val CHAPTER_ID : String = "chapter_id"

        const val CHAPTER_ID_PROP : String = "chapterId"

        const val VIDEO : String = "video"

        const val VIDEO_PROP : String = "video"

        const val TIME : String = "time"

        const val TIME_PROP : String = "time"

        const val CHARGE : String = "charge"

        const val CHARGE_PROP : String = "charge"

        const val SORT : String = "sort"

        const val SORT_PROP : String = "sort"

        const val CREATED_AT : String = "created_at"

        const val CREATED_AT_PROP : String = "createdAt"

        const val UPDATED_AT : String = "updated_at"

        const val UPDATED_AT_PROP : String = "updatedAt"

        const val VOD : String = "vod"

        const val VOD_PROP : String = "vod"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SectionMbpPo) return false
        if (id != other.id) return false
        if (title != other.title) return false
        if (courseId != other.courseId) return false
        if (chapterId != other.chapterId) return false
        if (video != other.video) return false
        if (time != other.time) return false
        if (charge != other.charge) return false
        if (sort != other.sort) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false
        if (vod != other.vod) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (courseId?.hashCode() ?: 0)
        result = 31 * result + (chapterId?.hashCode() ?: 0)
        result = 31 * result + (video?.hashCode() ?: 0)
        result = 31 * result + (time?.hashCode() ?: 0)
        result = 31 * result + (charge?.hashCode() ?: 0)
        result = 31 * result + (sort?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (vod?.hashCode() ?: 0)
        return result
    }

}
