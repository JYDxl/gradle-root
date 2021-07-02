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
@TableName("admin_qrtz_job_details")
@ApiModel(value = "AdminQrtzJobDetailsEntity对象", description = "")
open class AdminQrtzJobDetailsEntity : Entity() {

    @TableId(value = "SCHED_NAME", type = IdType.ASSIGN_ID)
    open var schedName: String? = null

    @TableId(value = "JOB_NAME", type = IdType.ASSIGN_ID)
    open var jobName: String? = null

    @TableId(value = "JOB_GROUP", type = IdType.ASSIGN_ID)
    open var jobGroup: String? = null

    open var description: String? = null

    @TableField("JOB_CLASS_NAME")
    open var jobClassName: String? = null

    @TableField("IS_DURABLE")
    open var isDurable: String? = null

    @TableField("IS_NONCONCURRENT")
    open var isNonconcurrent: String? = null

    @TableField("IS_UPDATE_DATA")
    open var isUpdateData: String? = null

    @TableField("REQUESTS_RECOVERY")
    open var requestsRecovery: String? = null

    @TableField("JOB_DATA")
    open var jobData: Blob? = null

    companion object {

        private const val serialVersionUID = 1L

        const val SCHED_NAME : String = "SCHED_NAME"

        const val JOB_NAME : String = "JOB_NAME"

        const val JOB_GROUP : String = "JOB_GROUP"

        const val DESCRIPTION : String = "DESCRIPTION"

        const val JOB_CLASS_NAME : String = "JOB_CLASS_NAME"

        const val IS_DURABLE : String = "IS_DURABLE"

        const val IS_NONCONCURRENT : String = "IS_NONCONCURRENT"

        const val IS_UPDATE_DATA : String = "IS_UPDATE_DATA"

        const val REQUESTS_RECOVERY : String = "REQUESTS_RECOVERY"

        const val JOB_DATA : String = "JOB_DATA"

    }

    override fun pkVal(): java.io.Serializable? {
        return jobGroup
    }

    override fun toString(): String {
        return "AdminQrtzJobDetailsEntity{" +
        "schedName=" + schedName +
        ", jobName=" + jobName +
        ", jobGroup=" + jobGroup +
        ", description=" + description +
        ", jobClassName=" + jobClassName +
        ", isDurable=" + isDurable +
        ", isNonconcurrent=" + isNonconcurrent +
        ", isUpdateData=" + isUpdateData +
        ", requestsRecovery=" + requestsRecovery +
        ", jobData=" + jobData +
        "}"
    }

}
