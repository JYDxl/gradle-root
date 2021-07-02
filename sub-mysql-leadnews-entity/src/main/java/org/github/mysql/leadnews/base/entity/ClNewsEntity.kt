package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("cl_news")
@ApiModel(value = "ClNewsEntity对象", description = "")
open class ClNewsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 任务ID */
    @ApiModelProperty(value = "任务ID")
    @TableField("task_id")
    open var taskId: Int? = null

    /** 连接URL */
    @ApiModelProperty(value = "连接URL")
    open var url: String? = null

    /** 标题 */
    @ApiModelProperty(value = "标题")
    open var title: String? = null

    /** 作者名称 */
    @ApiModelProperty(value = "作者名称")
    open var name: String? = null

    /** 图文内容 */
    @ApiModelProperty(value = "图文内容")
    open var content: String? = null

    /** 文章布局  0 无图文章 1 单图文章 2 多图文章 */
    @ApiModelProperty(value = "文章布局  0 无图文章 1 单图文章 2 多图文章")
    open var type: Int? = null

    /** 图文频道ID */
    @ApiModelProperty(value = "图文频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    open var labels: String? = null

    /** label关联ID */
    @ApiModelProperty(value = "label关联ID")
    @TableField("label_ids")
    open var labelIds: String? = null

    /** 原文时间 */
    @ApiModelProperty(value = "原文时间")
    @TableField("original_time")
    open var originalTime: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 提交时间 */
    @ApiModelProperty(value = "提交时间")
    @TableField("submited_time")
    open var submitedTime: LocalDateTime? = null

    /** 当前状态 0 草稿 1 提交（待审核） 2 审核失败 8 审核通过（待发布） 9 已发布 */
    @ApiModelProperty(value = "当前状态 0 草稿 1 提交（待审核） 2 审核失败 8 审核通过（待发布） 9 已发布")
    open var status: Int? = null

    /** 定时发布时间，不定时则为空 */
    @ApiModelProperty(value = "定时发布时间，不定时则为空")
    @TableField("publish_time")
    open var publishTime: LocalDateTime? = null

    /** 拒绝理由 */
    @ApiModelProperty(value = "拒绝理由")
    open var reason: String? = null

    /** 发布库文章ID */
    @ApiModelProperty(value = "发布库文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 任务批次 */
    @ApiModelProperty(value = "任务批次")
    open var no: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TASK_ID : String = "task_id"

        const val URL : String = "url"

        const val TITLE : String = "title"

        const val NAME : String = "name"

        const val CONTENT : String = "content"

        const val TYPE : String = "type"

        const val CHANNEL_ID : String = "channel_id"

        const val LABELS : String = "labels"

        const val LABEL_IDS : String = "label_ids"

        const val ORIGINAL_TIME : String = "original_time"

        const val CREATED_TIME : String = "created_time"

        const val SUBMITED_TIME : String = "submited_time"

        const val STATUS : String = "status"

        const val PUBLISH_TIME : String = "publish_time"

        const val REASON : String = "reason"

        const val ARTICLE_ID : String = "article_id"

        const val NO : String = "no"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClNewsEntity{" +
        "id=" + id +
        ", taskId=" + taskId +
        ", url=" + url +
        ", title=" + title +
        ", name=" + name +
        ", content=" + content +
        ", type=" + type +
        ", channelId=" + channelId +
        ", labels=" + labels +
        ", labelIds=" + labelIds +
        ", originalTime=" + originalTime +
        ", createdTime=" + createdTime +
        ", submitedTime=" + submitedTime +
        ", status=" + status +
        ", publishTime=" + publishTime +
        ", reason=" + reason +
        ", articleId=" + articleId +
        ", no=" + no +
        "}"
    }

}
