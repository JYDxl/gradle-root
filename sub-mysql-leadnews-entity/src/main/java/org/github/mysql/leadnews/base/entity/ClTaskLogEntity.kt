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
 * 爬取日志表
 *
 * @author JYD_XL
 */
@TableName("cl_task_log")
@ApiModel(value = "ClTaskLogEntity对象", description = "爬取日志表")
open class ClTaskLogEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 任务ID */
    @ApiModelProperty(value = "任务ID")
    @TableField("task_id")
    open var taskId: Int? = null

    /** 任务批次 */
    @ApiModelProperty(value = "任务批次")
    open var no: Int? = null

    /** 爬得数量 */
    @ApiModelProperty(value = "爬得数量")
    open var count: Int? = null

    /** 是否有效 */
    @ApiModelProperty(value = "是否有效")
    @TableField("is_success")
    open var isSuccess: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("start_time")
    open var startTime: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("end_time")
    open var endTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TASK_ID : String = "task_id"

        const val NO : String = "no"

        const val COUNT : String = "count"

        const val IS_SUCCESS : String = "is_success"

        const val START_TIME : String = "start_time"

        const val END_TIME : String = "end_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClTaskLogEntity{" +
        "id=" + id +
        ", taskId=" + taskId +
        ", no=" + no +
        ", count=" + count +
        ", isSuccess=" + isSuccess +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}"
    }

}
