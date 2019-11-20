package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 定时任务调度表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_job")
class SysJobEntity: AbstractEntity() {

    /** 任务ID */
    @TableId(value = "job_id", type = IdType.AUTO)
    var jobId: Long? = null

    /** 任务名称 */
    var jobName: String? = null

    /** 任务组名 */
    var jobGroup: String? = null

    /** 调用目标字符串 */
    var invokeTarget: String? = null

    /** cron执行表达式 */
    var cronExpression: String? = null

    /** 计划执行错误策略（1立即执行 2执行一次 3放弃执行） */
    var misfirePolicy: String? = null

    /** 是否并发执行（0允许 1禁止） */
    var concurrent: String? = null

    /** 状态（0正常 1暂停） */
    var status: String? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

    /** 备注信息 */
    var remark: String? = null

}
