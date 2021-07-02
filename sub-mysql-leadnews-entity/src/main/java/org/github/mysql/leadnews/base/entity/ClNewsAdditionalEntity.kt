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
 * 爬得图文附属信息表
 *
 * @author JYD_XL
 */
@TableName("cl_news_additional")
@ApiModel(value = "ClNewsAdditionalEntity对象", description = "爬得图文附属信息表")
open class ClNewsAdditionalEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 图文ID */
    @ApiModelProperty(value = "图文ID")
    @TableField("news_id")
    open var newsId: Int? = null

    /** 原文地址 */
    @ApiModelProperty(value = "原文地址")
    open var url: String? = null

    /** 阅读量 */
    @ApiModelProperty(value = "阅读量")
    @TableField("read_count")
    open var readCount: Int? = null

    open var likes: Int? = null

    open var comment: Int? = null

    open var forward: Int? = null

    open var unlikes: Int? = null

    open var collection: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    open var count: LocalDateTime? = null

    /** 更新次数 */
    @ApiModelProperty(value = "更新次数")
    @TableField("update_num")
    open var updateNum: Int? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    /** 下次更新时间 */
    @ApiModelProperty(value = "下次更新时间")
    @TableField("next_update_time")
    open var nextUpdateTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NEWS_ID : String = "news_id"

        const val URL : String = "url"

        const val READ_COUNT : String = "read_count"

        const val LIKES : String = "likes"

        const val COMMENT : String = "comment"

        const val FORWARD : String = "forward"

        const val UNLIKES : String = "unlikes"

        const val COLLECTION : String = "collection"

        const val CREATED_TIME : String = "created_time"

        const val COUNT : String = "count"

        const val UPDATE_NUM : String = "update_num"

        const val UPDATED_TIME : String = "updated_time"

        const val NEXT_UPDATE_TIME : String = "next_update_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClNewsAdditionalEntity{" +
        "id=" + id +
        ", newsId=" + newsId +
        ", url=" + url +
        ", readCount=" + readCount +
        ", likes=" + likes +
        ", comment=" + comment +
        ", forward=" + forward +
        ", unlikes=" + unlikes +
        ", collection=" + collection +
        ", createdTime=" + createdTime +
        ", count=" + count +
        ", updateNum=" + updateNum +
        ", updatedTime=" + updatedTime +
        ", nextUpdateTime=" + nextUpdateTime +
        "}"
    }

}
