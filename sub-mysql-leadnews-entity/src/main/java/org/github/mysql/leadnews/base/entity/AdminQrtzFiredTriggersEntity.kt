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
@TableName("admin_qrtz_fired_triggers")
@ApiModel(value = "AdminQrtzFiredTriggersEntity对象", description = "")
open class AdminQrtzFiredTriggersEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "ENTRY_ID", type = IdType.ASSIGN_ID)
    open var entryId: String? = null

    @TableField("TRIGGER_NAME")
    open var triggerName: String? = null

    @TableField("TRIGGER_GROUP")
    open var triggerGroup: String? = null

    @TableField("INSTANCE_NAME")
    open var instanceName: String? = null

    @TableField("FIRED_TIME")
    open var firedTime: Long? = null

    @TableField("SCHED_TIME")
    open var schedTime: Long? = null

    open var priority: Int? = null

    open var state: String? = null

    @TableField("JOB_NAME")
    open var jobName: String? = null

    @TableField("JOB_GROUP")
    open var jobGroup: String? = null

    @TableField("IS_NONCONCURRENT")
    open var isNonconcurrent: String? = null

    @TableField("REQUESTS_RECOVERY")
    open var requestsRecovery: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val ENTRY_ID : String = "ENTRY_ID"

        const val TRIGGER_NAME : String = "TRIGGER_NAME"

        const val TRIGGER_GROUP : String = "TRIGGER_GROUP"

        const val INSTANCE_NAME : String = "INSTANCE_NAME"

        const val FIRED_TIME : String = "FIRED_TIME"

        const val SCHED_TIME : String = "SCHED_TIME"

        const val PRIORITY : String = "PRIORITY"

        const val STATE : String = "STATE"

        const val JOB_NAME : String = "JOB_NAME"

        const val JOB_GROUP : String = "JOB_GROUP"

        const val IS_NONCONCURRENT : String = "IS_NONCONCURRENT"

        const val REQUESTS_RECOVERY : String = "REQUESTS_RECOVERY"

    }

    override fun pkVal(): java.io.Serializable? {
        return entryId
    }

    override fun toString(): String {
        return "AdminQrtzFiredTriggersEntity{" +
        "schedName=" + schedName +
        ", entryId=" + entryId +
        ", triggerName=" + triggerName +
        ", triggerGroup=" + triggerGroup +
        ", instanceName=" + instanceName +
        ", firedTime=" + firedTime +
        ", schedTime=" + schedTime +
        ", priority=" + priority +
        ", state=" + state +
        ", jobName=" + jobName +
        ", jobGroup=" + jobGroup +
        ", isNonconcurrent=" + isNonconcurrent +
        ", requestsRecovery=" + requestsRecovery +
        "}"
    }

}
