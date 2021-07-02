package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDate
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 爬得图文评论信息表
 *
 * @author JYD_XL
 */
@TableName("cl_news_comments")
@ApiModel(value = "ClNewsCommentsEntity对象", description = "爬得图文评论信息表")
open class ClNewsCommentsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 图文ID */
    @ApiModelProperty(value = "图文ID")
    @TableField("news_id")
    open var newsId: Int? = null

    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    open var username: String? = null

    /** 评论内容 */
    @ApiModelProperty(value = "评论内容")
    open var content: String? = null

    /** 评论日期 */
    @ApiModelProperty(value = "评论日期")
    @TableField("comment_date")
    open var commentDate: LocalDate? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NEWS_ID : String = "news_id"

        const val USERNAME : String = "username"

        const val CONTENT : String = "content"

        const val COMMENT_DATE : String = "comment_date"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClNewsCommentsEntity{" +
        "id=" + id +
        ", newsId=" + newsId +
        ", username=" + username +
        ", content=" + content +
        ", commentDate=" + commentDate +
        ", createdTime=" + createdTime +
        "}"
    }

}
