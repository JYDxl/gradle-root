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
 * APP用户文章列表
 *
 * @author JYD_XL
 */
@TableName("ap_user_article_list")
@ApiModel(value = "ApUserArticleListEntity对象", description = "APP用户文章列表")
open class ApUserArticleListEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 频道ID */
    @ApiModelProperty(value = "频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    /** 动态ID */
    @ApiModelProperty(value = "动态ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 是否展示 */
    @ApiModelProperty(value = "是否展示")
    @TableField("is_show")
    open var isShow: Int? = null

    /** 推荐时间 */
    @ApiModelProperty(value = "推荐时间")
    @TableField("recommend_time")
    open var recommendTime: LocalDateTime? = null

    /** 是否阅读 */
    @ApiModelProperty(value = "是否阅读")
    @TableField("is_read")
    open var isRead: Int? = null

    /** 推荐算法 */
    @ApiModelProperty(value = "推荐算法")
    @TableField("strategy_id")
    open var strategyId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val CHANNEL_ID : String = "channel_id"

        const val ARTICLE_ID : String = "article_id"

        const val IS_SHOW : String = "is_show"

        const val RECOMMEND_TIME : String = "recommend_time"

        const val IS_READ : String = "is_read"

        const val STRATEGY_ID : String = "strategy_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserArticleListEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", channelId=" + channelId +
        ", articleId=" + articleId +
        ", isShow=" + isShow +
        ", recommendTime=" + recommendTime +
        ", isRead=" + isRead +
        ", strategyId=" + strategyId +
        "}"
    }

}
