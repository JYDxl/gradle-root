package org.github.mysql.blog.base.entity

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
@TableName("tb_article")
@ApiModel(value = "ArticleEntity对象", description = "")
open class ArticleEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 作者 */
    @ApiModelProperty(value = "作者")
    @TableField("user_id")
    open var userId: Int? = null

    /** 文章分类 */
    @ApiModelProperty(value = "文章分类")
    @TableField("category_id")
    open var categoryId: Int? = null

    /** 文章缩略图 */
    @ApiModelProperty(value = "文章缩略图")
    @TableField("article_cover")
    open var articleCover: String? = null

    /** 标题 */
    @ApiModelProperty(value = "标题")
    @TableField("article_title")
    open var articleTitle: String? = null

    /** 内容 */
    @ApiModelProperty(value = "内容")
    @TableField("article_content")
    open var articleContent: String? = null

    /** 发表时间 */
    @ApiModelProperty(value = "发表时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 是否置顶 0否 1是 */
    @ApiModelProperty(value = "是否置顶 0否 1是")
    @TableField("is_top")
    open var isTop: Boolean? = null

    /** 是否为草稿 0否 1是 */
    @ApiModelProperty(value = "是否为草稿 0否 1是")
    @TableField("is_draft")
    open var isDraft: Boolean? = null

    /** 是否删除  0否 1是 */
    @ApiModelProperty(value = "是否删除  0否 1是")
    @TableField("is_delete")
    open var isDelete: Boolean? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val CATEGORY_ID : String = "category_id"

        const val ARTICLE_COVER : String = "article_cover"

        const val ARTICLE_TITLE : String = "article_title"

        const val ARTICLE_CONTENT : String = "article_content"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_TOP : String = "is_top"

        const val IS_DRAFT : String = "is_draft"

        const val IS_DELETE : String = "is_delete"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ArticleEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", categoryId=" + categoryId +
        ", articleCover=" + articleCover +
        ", articleTitle=" + articleTitle +
        ", articleContent=" + articleContent +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isTop=" + isTop +
        ", isDraft=" + isDraft +
        ", isDelete=" + isDelete +
        "}"
    }

}
