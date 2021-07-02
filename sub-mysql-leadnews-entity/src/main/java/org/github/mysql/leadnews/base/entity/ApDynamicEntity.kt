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
 * APP用户动态信息表
 *
 * @author JYD_XL
 */
@TableName("ap_dynamic")
@ApiModel(value = "ApDynamicEntity对象", description = "APP用户动态信息表")
open class ApDynamicEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 文章作者的ID */
    @ApiModelProperty(value = "文章作者的ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 作者昵称 */
    @ApiModelProperty(value = "作者昵称")
    @TableField("user_name")
    open var userName: String? = null

    /** 频道名称 */
    @ApiModelProperty(value = "频道名称")
    open var content: String? = null

    /** 是否转发 */
    @ApiModelProperty(value = "是否转发")
    @TableField("is_forward")
    open var isForward: Int? = null

    /** 转发文章ID */
    @ApiModelProperty(value = "转发文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 转发文章标题 */
    @ApiModelProperty(value = "转发文章标题")
    @TableField("articel_title")
    open var articelTitle: String? = null

    /** 转发文章图片 */
    @ApiModelProperty(value = "转发文章图片")
    @TableField("article_image")
    open var articleImage: String? = null

    /** 布局标识	            0 无图动态	            1 单图动态	            2 多图动态	            3 转发动态 */
    @ApiModelProperty(value = "布局标识	            0 无图动态	            1 单图动态	            2 多图动态	            3 转发动态")
    open var layout: Int? = null

    /** 文章图片	            多张逗号分隔 */
    @ApiModelProperty(value = "文章图片	            多张逗号分隔")
    open var images: String? = null

    /** 点赞数量 */
    @ApiModelProperty(value = "点赞数量")
    open var likes: Int? = null

    /** 收藏数量 */
    @ApiModelProperty(value = "收藏数量")
    open var collection: Int? = null

    /** 评论数量 */
    @ApiModelProperty(value = "评论数量")
    open var comment: Int? = null

    /** 阅读数量 */
    @ApiModelProperty(value = "阅读数量")
    open var views: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val USER_NAME : String = "user_name"

        const val CONTENT : String = "content"

        const val IS_FORWARD : String = "is_forward"

        const val ARTICLE_ID : String = "article_id"

        const val ARTICEL_TITLE : String = "articel_title"

        const val ARTICLE_IMAGE : String = "article_image"

        const val LAYOUT : String = "layout"

        const val IMAGES : String = "images"

        const val LIKES : String = "likes"

        const val COLLECTION : String = "collection"

        const val COMMENT : String = "comment"

        const val VIEWS : String = "views"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApDynamicEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", content=" + content +
        ", isForward=" + isForward +
        ", articleId=" + articleId +
        ", articelTitle=" + articelTitle +
        ", articleImage=" + articleImage +
        ", layout=" + layout +
        ", images=" + images +
        ", likes=" + likes +
        ", collection=" + collection +
        ", comment=" + comment +
        ", views=" + views +
        ", createdTime=" + createdTime +
        "}"
    }

}
