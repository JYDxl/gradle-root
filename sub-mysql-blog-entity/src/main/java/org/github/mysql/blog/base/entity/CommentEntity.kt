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
@TableName("tb_comment")
@ApiModel(value = "CommentEntity对象", description = "")
open class CommentEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 评论用户Id */
    @ApiModelProperty(value = "评论用户Id")
    @TableField("user_id")
    open var userId: Int? = null

    /** 评论文章id */
    @ApiModelProperty(value = "评论文章id")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 评论内容 */
    @ApiModelProperty(value = "评论内容")
    @TableField("comment_content")
    open var commentContent: String? = null

    /** 评论时间 */
    @ApiModelProperty(value = "评论时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 回复用户id */
    @ApiModelProperty(value = "回复用户id")
    @TableField("reply_id")
    open var replyId: Int? = null

    /** 父评论id */
    @ApiModelProperty(value = "父评论id")
    @TableField("parent_id")
    open var parentId: Int? = null

    /** 是否删除  0否 1是 */
    @ApiModelProperty(value = "是否删除  0否 1是")
    @TableField("is_delete")
    open var isDelete: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val ARTICLE_ID : String = "article_id"

        const val COMMENT_CONTENT : String = "comment_content"

        const val CREATE_TIME : String = "create_time"

        const val REPLY_ID : String = "reply_id"

        const val PARENT_ID : String = "parent_id"

        const val IS_DELETE : String = "is_delete"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "CommentEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", articleId=" + articleId +
        ", commentContent=" + commentContent +
        ", createTime=" + createTime +
        ", replyId=" + replyId +
        ", parentId=" + parentId +
        ", isDelete=" + isDelete +
        "}"
    }

}
