package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 定时任务调度日志表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_job_log")
class SysJobLogEntity: AbstractEntity() {

    /** 任务日志ID */
    @TableId(value = "job_log_id", type = IdType.AUTO)
    var jobLogId: Long? = null

    /** 任务名称 */
    var jobName: String? = null

    /** 任务组名 */
    var jobGroup: String? = null

    /** 调用目标字符串 */
    var invokeTarget: String? = null

    /** 日志信息 */
    var jobMessage: String? = null

    /** 执行状态（0正常 1失败） */
    var status: String? = null

    /** 异常信息 */
    var exceptionInfo: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

}
