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
 * APP行为实体表,一个行为实体可能是用户或者设备，或者其它
 *
 * @author JYD_XL
 */
@TableName("ap_behavior_entry")
@ApiModel(value = "ApBehaviorEntryEntity对象", description = "APP行为实体表,一个行为实体可能是用户或者设备，或者其它")
open class ApBehaviorEntryEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 实体类型	            0终端设备	            1用户 */
    @ApiModelProperty(value = "实体类型	            0终端设备	            1用户")
    open var type: Int? = null

    /** 实体ID */
    @ApiModelProperty(value = "实体ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 分片 */
    @ApiModelProperty(value = "分片")
    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TYPE : String = "type"

        const val ENTRY_ID : String = "entry_id"

        const val CREATED_TIME : String = "created_time"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApBehaviorEntryEntity{" +
        "id=" + id +
        ", type=" + type +
        ", entryId=" + entryId +
        ", createdTime=" + createdTime +
        ", burst=" + burst +
        "}"
    }

}
