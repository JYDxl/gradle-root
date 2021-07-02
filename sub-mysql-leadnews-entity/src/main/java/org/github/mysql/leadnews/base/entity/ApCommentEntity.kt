package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP评论信息表
 *
 * @author JYD_XL
 */
@TableName("ap_comment")
@ApiModel(value = "ApCommentEntity对象", description = "APP评论信息表")
open class ApCommentEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("author_id")
    open var authorId: Int? = null

    /** 用户昵称 */
    @ApiModelProperty(value = "用户昵称")
    @TableField("author_name")
    open var authorName: String? = null

    @TableField("entry_id")
    open var entryId: Int? = null

    /** 频道ID */
    @ApiModelProperty(value = "频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    /** 评论内容类型	            0 文章	            1 动态 */
    @ApiModelProperty(value = "评论内容类型	            0 文章	            1 动态")
    open var type: Int? = null

    /** 评论内容 */
    @ApiModelProperty(value = "评论内容")
    open var content: String? = null

    open var image: String? = null

    open var likes: Int? = null

    open var reply: Int? = null

    /** 文章标记	            0 普通评论	            1 热点评论	            2 推荐评论	            3 置顶评论	            4 精品评论	            5 大V 评论 */
    @ApiModelProperty(value = "文章标记	            0 普通评论	            1 热点评论	            2 推荐评论	            3 置顶评论	            4 精品评论	            5 大V 评论")
    open var flag: Int? = null

    open var longitude: BigDecimal? = null

    /** 维度 */
    @ApiModelProperty(value = "维度")
    open var latitude: BigDecimal? = null

    /** 地理位置 */
    @ApiModelProperty(value = "地理位置")
    open var address: String? = null

    /** 评论排列序号 */
    @ApiModelProperty(value = "评论排列序号")
    open var ord: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val AUTHOR_ID : String = "author_id"

        const val AUTHOR_NAME : String = "author_name"

        const val ENTRY_ID : String = "entry_id"

        const val CHANNEL_ID : String = "channel_id"

        const val TYPE : String = "type"

        const val CONTENT : String = "content"

        const val IMAGE : String = "image"

        const val LIKES : String = "likes"

        const val REPLY : String = "reply"

        const val FLAG : String = "flag"

        const val LONGITUDE : String = "longitude"

        const val LATITUDE : String = "latitude"

        const val ADDRESS : String = "address"

        const val ORD : String = "ord"

        const val CREATED_TIME : String = "created_time"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApCommentEntity{" +
        "id=" + id +
        ", authorId=" + authorId +
        ", authorName=" + authorName +
        ", entryId=" + entryId +
        ", channelId=" + channelId +
        ", type=" + type +
        ", content=" + content +
        ", image=" + image +
        ", likes=" + likes +
        ", reply=" + reply +
        ", flag=" + flag +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", address=" + address +
        ", ord=" + ord +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}"
    }

}
