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

        const val TITLE : String = "title"

        const val COURSE_ID : String = "course_id"

        const val CHAPTER_ID : String = "chapter_id"

        const val VIDEO : String = "video"

        const val TIME : String = "time"

        const val CHARGE : String = "charge"

        const val SORT : String = "sort"

        const val CREATED_AT : String = "created_at"

        const val UPDATED_AT : String = "updated_at"

        const val VOD : String = "vod"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
