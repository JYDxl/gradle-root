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
 * tip_opt_log_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tip_opt_log")
public class TipOptLogEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "log_id", type = IdType.UUID)
    private String logId;

    /** 操作人 */
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
