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
 * APP收藏信息表
 *
 * @author JYD_XL
 */
@TableName("ap_collection")
@ApiModel(value = "ApCollectionEntity对象", description = "APP收藏信息表")
open class ApCollectionEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 实体ID */
    @ApiModelProperty(value = "实体ID")
    @TableField("behavior_entry_id")
    open var behaviorEntryId: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 点赞内容类型	            0文章	            1动态 */
    @ApiModelProperty(value = "点赞内容类型	            0文章	            1动态")
    open var type: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("collection_time")
    open var collectionTime: LocalDateTime? = null

    /** 发布时间 */
    @ApiModelProperty(value = "发布时间")
    @TableField("published_time")
    open var publishedTime: LocalDateTime? = null

    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val BEHAVIOR_ENTRY_ID : String = "behavior_entry_id"

        const val ENTRY_ID : String = "entry_id"

        const val TYPE : String = "type"

        const val COLLECTION_TIME : String = "collection_time"

        const val PUBLISHED_TIME : String = "published_time"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApCollectionEntity{" +
        "id=" + id +
        ", behaviorEntryId=" + behaviorEntryId +
        ", entryId=" + entryId +
        ", type=" + type +
        ", collectionTime=" + collectionTime +
        ", publishedTime=" + publishedTime +
        ", burst=" + burst +
        "}"
    }

}