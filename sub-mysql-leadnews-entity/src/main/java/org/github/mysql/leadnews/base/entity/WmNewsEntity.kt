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
 * 自媒体图文内容信息表
 *
 * @author JYD_XL
 */
@TableName("wm_news")
@ApiModel(value = "WmNewsEntity对象", description = "自媒体图文内容信息表")
open class WmNewsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 自媒体用户ID */
    @ApiModelProperty(value = "自媒体用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 标题 */
    @ApiModelProperty(value = "标题")
    open var title: String? = null

    /** 图文内容 */
    @ApiModelProperty(value = "图文内容")
    open var content: String? = null

    /** 文章布局	            0 无图文章	            1 单图文章	            2 多图文章 */
    @ApiModelProperty(value = "文章布局	            0 无图文章	            1 单图文章	            2 多图文章")
    open var type: Int? = null

    /** 图文频道ID */
    @ApiModelProperty(value = "图文频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    open var labels: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 提交时间 */
    @ApiModelProperty(value = "提交时间")
    @TableField("submited_time")
    open var submitedTime: LocalDateTime? = null

    /** 当前状态	            0 草稿	            1 提交（待审核）	            2 审核失败	            8 审核通过（待发布）	            9 已发布 */
    @ApiModelProperty(value = "当前状态	            0 草稿	            1 提交（待审核）	            2 审核失败	            8 审核通过（待发布）	            9 已发布")
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

    /** //图片用逗号分隔 */
    @ApiModelProperty(value = "//图片用逗号分隔")
    open var images: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val TITLE : String = "title"

        const val CONTENT : String = "content"

        const val TYPE : String = "type"

        const val CHANNEL_ID : String = "channel_id"

        const val LABELS : String = "labels"

        const val CREATED_TIME : String = "created_time"

        const val SUBMITED_TIME : String = "submited_time"

        const val STATUS : String = "status"

        const val PUBLISH_TIME : String = "publish_time"

        const val REASON : String = "reason"

        const val ARTICLE_ID : String = "article_id"

        const val IMAGES : String = "images"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmNewsEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", title=" + title +
        ", content=" + content +
        ", type=" + type +
        ", channelId=" + channelId +
        ", labels=" + labels +
        ", createdTime=" + createdTime +
        ", submitedTime=" + submitedTime +
        ", status=" + status +
        ", publishTime=" + publishTime +
        ", reason=" + reason +
        ", articleId=" + articleId +
        ", images=" + images +
        "}"
    }

}
