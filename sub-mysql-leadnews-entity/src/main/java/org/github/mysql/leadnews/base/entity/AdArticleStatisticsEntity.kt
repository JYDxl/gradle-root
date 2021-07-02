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
 * 文章数据统计表
 *
 * @author JYD_XL
 */
@TableName("ad_article_statistics")
@ApiModel(value = "AdArticleStatisticsEntity对象", description = "文章数据统计表")
open class AdArticleStatisticsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 主账号ID */
    @ApiModelProperty(value = "主账号ID")
    @TableField("article_we_media")
    open var articleWeMedia: Int? = null

    /** 子账号ID */
    @ApiModelProperty(value = "子账号ID")
    @TableField("article_crawlers")
    open var articleCrawlers: Int? = null

    /** 频道ID */
    @ApiModelProperty(value = "频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    /** 草读量 */
    @ApiModelProperty(value = "草读量")
    @TableField("read_20")
    open var read20: Int? = null

    /** 读完量 */
    @ApiModelProperty(value = "读完量")
    @TableField("read_100")
    open var read100: Int? = null

    /** 阅读量 */
    @ApiModelProperty(value = "阅读量")
    @TableField("read_count")
    open var readCount: Int? = null

    /** 评论量 */
    @ApiModelProperty(value = "评论量")
    open var comment: Int? = null

    /** 关注量 */
    @ApiModelProperty(value = "关注量")
    open var follow: Int? = null

    /** 收藏量 */
    @ApiModelProperty(value = "收藏量")
    open var collection: Int? = null

    /** 转发量 */
    @ApiModelProperty(value = "转发量")
    open var forward: Int? = null

    /** 点赞量 */
    @ApiModelProperty(value = "点赞量")
    open var likes: Int? = null

    /** 不喜欢 */
    @ApiModelProperty(value = "不喜欢")
    open var unlikes: Int? = null

    /** unfollow */
    @ApiModelProperty(value = "unfollow")
    open var unfollow: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ARTICLE_WE_MEDIA : String = "article_we_media"

        const val ARTICLE_CRAWLERS : String = "article_crawlers"

        const val CHANNEL_ID : String = "channel_id"

        const val READ_20 : String = "read_20"

        const val READ_100 : String = "read_100"

        const val READ_COUNT : String = "read_count"

        const val COMMENT : String = "comment"

        const val FOLLOW : String = "follow"

        const val COLLECTION : String = "collection"

        const val FORWARD : String = "forward"

        const val LIKES : String = "likes"

        const val UNLIKES : String = "unlikes"

        const val UNFOLLOW : String = "unfollow"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdArticleStatisticsEntity{" +
        "id=" + id +
        ", articleWeMedia=" + articleWeMedia +
        ", articleCrawlers=" + articleCrawlers +
        ", channelId=" + channelId +
        ", read20=" + read20 +
        ", read100=" + read100 +
        ", readCount=" + readCount +
        ", comment=" + comment +
        ", follow=" + follow +
        ", collection=" + collection +
        ", forward=" + forward +
        ", likes=" + likes +
        ", unlikes=" + unlikes +
        ", unfollow=" + unfollow +
        ", createdTime=" + createdTime +
        "}"
    }

}
