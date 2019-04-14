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
 * 其他-操作日志表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tip_opt_log")
public class TipOptLogEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 操作日志ID */
    @TableId(value = "log_id", type = IdType.UUID)
    private String logId;

    /** 操作用户 */
    private String optUser;

    /** 操作时间 */
    private LocalDateTime optDate;

    /** 操作内容 */
    private String optContent;

    /** 操作地址 */
    private String optAction;

    /** 操作IP */
    private String optIp;

}
