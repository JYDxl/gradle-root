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
 * 文章信息表，存储已发布的文章
 *
 * @author JYD_XL
 */
@TableName("ap_article")
@ApiModel(value = "ApArticleEntity对象", description = "文章信息表，存储已发布的文章")
open class ApArticleEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 标题 */
    @ApiModelProperty(value = "标题")
    open var title: String? = null

    /** 文章作者的ID */
    @ApiModelProperty(value = "文章作者的ID")
    @TableField("author_id")
    open var authorId: Int? = null

    /** 作者昵称 */
    @ApiModelProperty(value = "作者昵称")
    @TableField("author_name")
    open var authorName: String? = null

    /** 文章所属频道ID */
    @ApiModelProperty(value = "文章所属频道ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    /** 频道名称 */
    @ApiModelProperty(value = "频道名称")
    @TableField("channel_name")
    open var channelName: String? = null

    /** 文章布局	            0 无图文章	            1 单图文章	            2 多图文章 */
    @ApiModelProperty(value = "文章布局	            0 无图文章	            1 单图文章	            2 多图文章")
    open var layout: Int? = null

    /** 文章标记	            0 普通文章	            1 热点文章	            2 置顶文章	            3 精品文章	            4 大V 文章 */
    @ApiModelProperty(value = "文章标记	            0 普通文章	            1 热点文章	            2 置顶文章	            3 精品文章	            4 大V 文章")
    open var flag: Int? = null

    /** 文章图片	            多张逗号分隔 */
    @ApiModelProperty(value = "文章图片	            多张逗号分隔")
    open var images: String? = null

    /** 文章标签最多3个 逗号分隔 */
    @ApiModelProperty(value = "文章标签最多3个 逗号分隔")
    open var labels: String? = null

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

    /** 省市 */
    @ApiModelProperty(value = "省市")
    @TableField("province_id")
    open var provinceId: Int? = null

    /** 市区 */
    @ApiModelProperty(value = "市区")
    @TableField("city_id")
    open var cityId: Int? = null

    /** 区县 */
    @ApiModelProperty(value = "区县")
    @TableField("county_id")
    open var countyId: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 发布时间 */
    @ApiModelProperty(value = "发布时间")
    @TableField("publish_time")
    open var publishTime: LocalDateTime? = null

    /** 同步状态 */
    @ApiModelProperty(value = "同步状态")
    @TableField("sync_status")
    open var syncStatus: Boolean? = null

    /** 来源 */
    @ApiModelProperty(value = "来源")
    open var origin: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TITLE : String = "title"

        const val AUTHOR_ID : String = "author_id"

        const val AUTHOR_NAME : String = "author_name"

        const val CHANNEL_ID : String = "channel_id"

        const val CHANNEL_NAME : String = "channel_name"

        const val LAYOUT : String = "layout"

        const val FLAG : String = "flag"

        const val IMAGES : String = "images"

        const val LABELS : String = "labels"

        const val LIKES : String = "likes"

        const val COLLECTION : String = "collection"

        const val COMMENT : String = "comment"

        const val VIEWS : String = "views"

        const val PROVINCE_ID : String = "province_id"

        const val CITY_ID : String = "city_id"

        const val COUNTY_ID : String = "county_id"

        const val CREATED_TIME : String = "created_time"

        const val PUBLISH_TIME : String = "publish_time"

        const val SYNC_STATUS : String = "sync_status"

        const val ORIGIN : String = "origin"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApArticleEntity{" +
        "id=" + id +
        ", title=" + title +
        ", authorId=" + authorId +
        ", authorName=" + authorName +
        ", channelId=" + channelId +
        ", channelName=" + channelName +
        ", layout=" + layout +
        ", flag=" + flag +
        ", images=" + images +
        ", labels=" + labels +
        ", likes=" + likes +
        ", collection=" + collection +
        ", comment=" + comment +
        ", views=" + views +
        ", provinceId=" + provinceId +
        ", cityId=" + cityId +
        ", countyId=" + countyId +
        ", createdTime=" + createdTime +
        ", publishTime=" + publishTime +
        ", syncStatus=" + syncStatus +
        ", origin=" + origin +
        "}"
    }

}
