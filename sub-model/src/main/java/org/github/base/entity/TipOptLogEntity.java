package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * tip_opt_log_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-26
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
    @TableField("opt_user")
    private String optUser;

    /** 操作时间 */
    @TableField("opt_date")
    private LocalDateTime optDate;

    /** 操作内容 */
    @TableField("opt_content")
    private String optContent;

    /** 操作地址 */
    @TableField("opt_action")
    private String optAction;

    /** 操作IP */
    @TableField("opt_ip")
    private String optIp;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
