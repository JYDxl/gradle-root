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
@TableName("quartz_qrtz_cron_triggers")
@ApiModel(value = "QuartzQrtzCronTriggersEntity对象", description = "")
open class QuartzQrtzCronTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_NAME", type = IdType.ASSIGN_ID)
    open var triggerName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    @TableField("CRON_EXPRESSION")
    open var cronExpression: String? = null

    @TableField("TIME_ZONE_ID")
    open var timeZoneId: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val CRON_EXPRESSION : String = "CRON_EXPRESSION"

        const val TIME_ZONE_ID : String = "TIME_ZONE_ID"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "QuartzQrtzCronTriggersEntity{" +
        "schedName=" + schedName +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", cronExpression=" + cronExpression +
        ", timeZoneId=" + timeZoneId +
        "}"
    }

}
