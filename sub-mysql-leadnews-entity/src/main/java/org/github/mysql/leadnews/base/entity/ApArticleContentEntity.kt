package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP已发布文章内容表
 *
 * @author JYD_XL
 */
@TableName("ap_article_content")
@ApiModel(value = "ApArticleContentEntity对象", description = "APP已发布文章内容表")
open class ApArticleContentEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 文章内容 */
    @ApiModelProperty(value = "文章内容")
    open var content: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ARTICLE_ID : String = "article_id"

        const val CONTENT : String = "content"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApArticleContentEntity{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", content=" + content +
        "}"
    }

}
