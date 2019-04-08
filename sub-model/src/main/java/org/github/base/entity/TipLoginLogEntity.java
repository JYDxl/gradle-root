package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * tip_login_log_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tip_login_log")
public class TipLoginLogEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "log_id", type = IdType.UUID)
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
