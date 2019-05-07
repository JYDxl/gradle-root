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
 * 其他-登陆日志表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tip_login_log")
public class TipLoginLogEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    @TableId(value = "log_id", type = IdType.UUID)
    private String logId;

    /** 所属用户 */
    private String logUser;

    /** 记录时间 */
    private LocalDateTime logTime;

    /** 登录IP */
    private String logIp;

    /** 执行操作 */
    private String logAction;

}
