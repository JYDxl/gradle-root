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
 * 热文章表
 *
 * @author JYD_XL
 */
@TableName("ap_hot_articles")
@ApiModel(value = "ApHotArticlesEntity对象", description = "热文章表")
open class ApHotArticlesEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    @TableField("entry_id")
    open var entryId: Int? = null

    /** 频道ID */
    @ApiModelProperty(value = "频道ID")
    @TableField("tag_id")
    open var tagId: Int? = null

    /** 频道名称 */
    @ApiModelProperty(value = "频道名称")
    @TableField("tag_name")
    open var tagName: String? = null

    /** 热度评分 */
    @ApiModelProperty(value = "热度评分")
    open var score: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

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

    /** 是否阅读 */
    @ApiModelProperty(value = "是否阅读")
    @TableField("is_read")
    open var isRead: Int? = null

    @TableField("release_date")
    open var releaseDate: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ENTRY_ID : String = "entry_id"

        const val TAG_ID : String = "tag_id"

        const val TAG_NAME : String = "tag_name"

        const val SCORE : String = "score"

        const val ARTICLE_ID : String = "article_id"

        const val PROVINCE_ID : String = "province_id"

        const val CITY_ID : String = "city_id"

        const val COUNTY_ID : String = "county_id"

        const val IS_READ : String = "is_read"

        const val RELEASE_DATE : String = "release_date"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApHotArticlesEntity{" +
        "id=" + id +
        ", entryId=" + entryId +
        ", tagId=" + tagId +
        ", tagName=" + tagName +
        ", score=" + score +
        ", articleId=" + articleId +
        ", provinceId=" + provinceId +
        ", cityId=" + cityId +
        ", countyId=" + countyId +
        ", isRead=" + isRead +
        ", releaseDate=" + releaseDate +
        ", createdTime=" + createdTime +
        "}"
    }

}
