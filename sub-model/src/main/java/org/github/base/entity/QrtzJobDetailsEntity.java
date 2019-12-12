package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_job_details")
public class QrtzJobDetailsEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    @TableId(value = "sched_name", type = IdType.ASSIGN_UUID)
    private String schedName;

    @TableField("job_name")
    private String jobName;

    @TableField("job_group")
    private String jobGroup;

    @TableField("description")
    private String description;

    @TableField("job_class_name")
    private String jobClassName;

    @TableField("is_durable")
    private String isDurable;

    @TableField("is_nonconcurrent")
    private String isNonconcurrent;

    @TableField("is_update_data")
    private String isUpdateData;

    @TableField("requests_recovery")
    private String requestsRecovery;

    @TableField("job_data")
    private Blob jobData;
}
