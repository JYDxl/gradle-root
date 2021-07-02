package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP已发布文章配置表
 *
 * @author JYD_XL
 */
@TableName("ap_article_config")
@ApiModel(value = "ApArticleConfigEntity对象", description = "APP已发布文章配置表")
open class ApArticleConfigEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 是否可评论 */
    @ApiModelProperty(value = "是否可评论")
    @TableField("is_comment")
    open var isComment: Int? = null

    /** 是否转发 */
    @ApiModelProperty(value = "是否转发")
    @TableField("is_forward")
    open var isForward: Int? = null

    /** 是否下架 */
    @ApiModelProperty(value = "是否下架")
    @TableField("is_down")
    open var isDown: Int? = null

    /** 是否已删除 */
    @ApiModelProperty(value = "是否已删除")
    @TableField("is_delete")
    open var isDelete: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ARTICLE_ID : String = "article_id"

        const val IS_COMMENT : String = "is_comment"

        const val IS_FORWARD : String = "is_forward"

        const val IS_DOWN : String = "is_down"

        const val IS_DELETE : String = "is_delete"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApArticleConfigEntity{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", isComment=" + isComment +
        ", isForward=" + isForward +
        ", isDown=" + isDown +
        ", isDelete=" + isDelete +
        "}"
    }

}
