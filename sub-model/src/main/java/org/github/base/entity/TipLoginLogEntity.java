package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * tip_login_log_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tip_login_log")
public class TipLoginLogEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "log_id", type = IdType.ID_WORKER_STR)
    private String logId;

    /** log_user */
    private String logUser;

    /** log_time */
    private LocalDateTime logTime;

    /** log_ip */
    private String logIp;

    /** log_action */
    private String logAction;

}
