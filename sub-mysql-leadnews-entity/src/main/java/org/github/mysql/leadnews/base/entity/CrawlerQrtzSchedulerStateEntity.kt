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
@TableName("crawler_qrtz_scheduler_state")
@ApiModel(value = "CrawlerQrtzSchedulerStateEntity对象", description = "")
open class CrawlerQrtzSchedulerStateEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "INSTANCE_NAME", type = IdType.ASSIGN_ID)
    open var instanceName: String? = null

    @TableField("LAST_CHECKIN_TIME")
    open var lastCheckinTime: Long? = null

    @TableField("CHECKIN_INTERVAL")
    open var checkinInterval: Long? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val INSTANCE_NAME : String = "INSTANCE_NAME"

        const val LAST_CHECKIN_TIME : String = "LAST_CHECKIN_TIME"

        const val CHECKIN_INTERVAL : String = "CHECKIN_INTERVAL"

    }

    override fun pkVal(): java.io.Serializable? {
        return instanceName
    }

    override fun toString(): String {
        return "CrawlerQrtzSchedulerStateEntity{" +
        "schedName=" + schedName +
        ", instanceName=" + instanceName +
        ", lastCheckinTime=" + lastCheckinTime +
        ", checkinInterval=" + checkinInterval +
        "}"
    }

}
