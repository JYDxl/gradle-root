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
 * APP评论回复信息表
 *
 * @author JYD_XL
 */
@TableName("ap_comment_repay")
@ApiModel(value = "ApCommentRepayEntity对象", description = "APP评论回复信息表")
open class ApCommentRepayEntity : Entity() {

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

    @TableField("comment_id")
    open var commentId: Int? = null

    /** 评论内容 */
    @ApiModelProperty(value = "评论内容")
    open var content: String? = null

    open var likes: Int? = null

    open var longitude: BigDecimal? = null

    /** 维度 */
    @ApiModelProperty(value = "维度")
    open var latitude: BigDecimal? = null

    /** 地理位置 */
    @ApiModelProperty(value = "地理位置")
    open var address: String? = null

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

        const val COMMENT_ID : String = "comment_id"

        const val CONTENT : String = "content"

        const val LIKES : String = "likes"

        const val LONGITUDE : String = "longitude"

        const val LATITUDE : String = "latitude"

        const val ADDRESS : String = "address"

        const val CREATED_TIME : String = "created_time"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApCommentRepayEntity{" +
        "id=" + id +
        ", authorId=" + authorId +
        ", authorName=" + authorName +
        ", commentId=" + commentId +
        ", content=" + content +
        ", likes=" + likes +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", address=" + address +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}"
    }

}
