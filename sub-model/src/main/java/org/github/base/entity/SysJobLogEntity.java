package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 定时任务调度日志表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_job_log")
public class SysJobLogEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 任务日志ID */
    @TableId(value = "job_log_id", type = IdType.AUTO)
    private Long jobLogId;

    /** 任务名称 */
    @TableField("job_name")
    private String jobName;

    /** 任务组名 */
    @TableField("job_group")
    private String jobGroup;

    /** 调用目标字符串 */
    @TableField("invoke_target")
    private String invokeTarget;

    /** 日志信息 */
    @TableField("job_message")
    private String jobMessage;

    /** 执行状态（0正常 1失败） */
    @TableField("status")
    private String status;

    /** 异常信息 */
    @TableField("exception_info")
    private String exceptionInfo;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;
}
