package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_article_tag")
@ApiModel(value = "ArticleTagEntity对象", description = "")
open class ArticleTagEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 文章id */
    @ApiModelProperty(value = "文章id")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 标签id */
    @ApiModelProperty(value = "标签id")
    @TableField("tag_id")
    open var tagId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ARTICLE_ID : String = "article_id"

        const val TAG_ID : String = "tag_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ArticleTagEntity{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", tagId=" + tagId +
        "}"
    }

}
