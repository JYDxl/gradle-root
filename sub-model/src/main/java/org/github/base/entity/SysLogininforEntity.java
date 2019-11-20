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
 * 系统访问记录
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_logininfor")
public class SysLogininforEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 访问ID */
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    /** 登录账号 */
    @TableField("login_name")
    private String loginName;

    /** 登录IP地址 */
    @TableField("ipaddr")
    private String ipaddr;

    /** 登录地点 */
    @TableField("login_location")
    private String loginLocation;

    /** 浏览器类型 */
    @TableField("browser")
    private String browser;

    /** 操作系统 */
    @TableField("os")
    private String os;

    /** 登录状态（0成功 1失败） */
    @TableField("status")
    private String status;

    /** 提示消息 */
    @TableField("msg")
    private String msg;

    /** 访问时间 */
    @TableField("login_time")
    private LocalDateTime loginTime;
}
