package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 文章标签信息表
 *
 * @author JYD_XL
 */
@TableName("ap_article_label")
@ApiModel(value = "ApArticleLabelEntity对象", description = "文章标签信息表")
open class ApArticleLabelEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    @TableField("article_id")
    open var articleId: Int? = null

    /** 标签ID */
    @ApiModelProperty(value = "标签ID")
    @TableField("label_id")
    open var labelId: Int? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    open var count: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ARTICLE_ID : String = "article_id"

        const val LABEL_ID : String = "label_id"

        const val COUNT : String = "count"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApArticleLabelEntity{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", labelId=" + labelId +
        ", count=" + count +
        "}"
    }

}
