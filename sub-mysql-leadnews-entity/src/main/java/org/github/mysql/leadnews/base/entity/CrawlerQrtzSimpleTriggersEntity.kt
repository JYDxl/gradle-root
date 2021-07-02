package org.github.mysql.leadnews.base.entity

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
@TableName("crawler_qrtz_simple_triggers")
@ApiModel(value = "CrawlerQrtzSimpleTriggersEntity对象", description = "")
open class CrawlerQrtzSimpleTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_NAME", type = IdType.ASSIGN_ID)
    open var triggerName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    @TableField("REPEAT_COUNT")
    open var repeatCount: Long? = null

    @TableField("REPEAT_INTERVAL")
    open var repeatInterval: Long? = null

    @TableField("TIMES_TRIGGERED")
    open var timesTriggered: Long? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val REPEAT_COUNT : String = "REPEAT_COUNT"

        const val REPEAT_INTERVAL : String = "REPEAT_INTERVAL"

        const val TIMES_TRIGGERED : String = "TIMES_TRIGGERED"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "CrawlerQrtzSimpleTriggersEntity{" +
        "schedName=" + schedName +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", repeatCount=" + repeatCount +
        ", repeatInterval=" + repeatInterval +
        ", timesTriggered=" + timesTriggered +
        "}"
    }

}
