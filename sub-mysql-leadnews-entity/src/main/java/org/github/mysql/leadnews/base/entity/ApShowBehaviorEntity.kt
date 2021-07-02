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
 * APP文章展现行为表
 *
 * @author JYD_XL
 */
@TableName("ap_show_behavior")
@ApiModel(value = "ApShowBehaviorEntity对象", description = "APP文章展现行为表")
open class ApShowBehaviorEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 实体ID */
    @ApiModelProperty(value = "实体ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    /** 是否点击 */
    @ApiModelProperty(value = "是否点击")
    @TableField("is_click")
    open var isClick: Int? = null

    /** 文章加载时间 */
    @ApiModelProperty(value = "文章加载时间")
    @TableField("show_time")
    open var showTime: LocalDateTime? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ENTRY_ID : String = "entry_id"

        const val ARTICLE_ID : String = "article_id"

        const val IS_CLICK : String = "is_click"

        const val SHOW_TIME : String = "show_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApShowBehaviorEntity{" +
        "id=" + id +
        ", entryId=" + entryId +
        ", articleId=" + articleId +
        ", isClick=" + isClick +
        ", showTime=" + showTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
