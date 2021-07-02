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
 * APP点赞行为表
 *
 * @author JYD_XL
 */
@TableName("ap_likes_behavior")
@ApiModel(value = "ApLikesBehaviorEntity对象", description = "APP点赞行为表")
open class ApLikesBehaviorEntity : Entity() {

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

    /** 0 点赞	            1 取消点赞 */
    @ApiModelProperty(value = "0 点赞	            1 取消点赞")
    open var operation: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val BEHAVIOR_ENTRY_ID : String = "behavior_entry_id"

        const val ENTRY_ID : String = "entry_id"

        const val TYPE : String = "type"

        const val OPERATION : String = "operation"

        const val CREATED_TIME : String = "created_time"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApLikesBehaviorEntity{" +
        "id=" + id +
        ", behaviorEntryId=" + behaviorEntryId +
        ", entryId=" + entryId +
        ", type=" + type +
        ", operation=" + operation +
        ", createdTime=" + createdTime +
        ", burst=" + burst +
        "}"
    }

}
