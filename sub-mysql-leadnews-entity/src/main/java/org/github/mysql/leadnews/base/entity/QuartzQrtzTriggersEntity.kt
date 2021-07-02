package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.sql.Blob
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("quartz_qrtz_triggers")
@ApiModel(value = "QuartzQrtzTriggersEntity对象", description = "")
open class QuartzQrtzTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "TRIGGER_NAME", type = IdType.ASSIGN_ID)
    open var triggerName: String? = null

    @TableId(value = "TRIGGER_GROUP", type = IdType.ASSIGN_ID)
    open var triggerGroup: String? = null

    @TableField("JOB_NAME")
    open var jobName: String? = null

    @TableField("JOB_GROUP")
    open var jobGroup: String? = null

    open var description: String? = null

    @TableField("NEXT_FIRE_TIME")
    open var nextFireTime: Long? = null

    @TableField("PREV_FIRE_TIME")
    open var prevFireTime: Long? = null

    open var priority: Int? = null

    @TableField("TRIGGER_STATE")
    open var triggerState: String? = null

    @TableField("TRIGGER_TYPE")
    open var triggerType: String? = null

    @TableField("START_TIME")
    open var startTime: Long? = null

    @TableField("END_TIME")
    open var endTime: Long? = null

    @TableField("CALENDAR_NAME")
    open var calendarName: String? = null

    @TableField("MISFIRE_INSTR")
    open var misfireInstr: Int? = null

    @TableField("JOB_DATA")
    open var jobData: Blob? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val JOB_NAME : String = "JOB_NAME"

        const val JOB_GROUP : String = "JOB_GROUP"

        const val DESCRIPTION : String = "DESCRIPTION"

        const val NEXT_FIRE_TIME : String = "NEXT_FIRE_TIME"

        const val PREV_FIRE_TIME : String = "PREV_FIRE_TIME"

        const val PRIORITY : String = "PRIORITY"

        const val TRIGGER_STATE : String = "TRIGGER_STATE"

        const val TRIGGER_TYPE : String = "TRIGGER_TYPE"

        const val START_TIME : String = "START_TIME"

        const val END_TIME : String = "END_TIME"

        const val CALENDAR_NAME : String = "CALENDAR_NAME"

        const val MISFIRE_INSTR : String = "MISFIRE_INSTR"

        const val JOB_DATA : String = "JOB_DATA"

    }

    override fun pkVal(): java.io.Serializable? {
        return triggerGroup
    }

    override fun toString(): String {
        return "QuartzQrtzTriggersEntity{" +
        "schedName=" + schedName +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", jobName=" + jobName +
        ", jobGroup=" + jobGroup +
        ", description=" + description +
        ", nextFireTime=" + nextFireTime +
        ", prevFireTime=" + prevFireTime +
        ", priority=" + priority +
        ", triggerState=" + triggerState +
        ", triggerType=" + triggerType +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", calendarName=" + calendarName +
        ", misfireInstr=" + misfireInstr +
        ", jobData=" + jobData +
        "}"
    }

}
