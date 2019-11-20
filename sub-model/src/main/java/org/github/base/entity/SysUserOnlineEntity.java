package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 在线用户记录
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_online")
public class SysUserOnlineEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 用户会话id */
    @TableId("sessionId")
    private String sessionId;

    /** 登录账号 */
    @TableField("login_name")
    private String loginName;

    /** 部门名称 */
    @TableField("dept_name")
    private String deptName;

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

    /** 在线状态on_line在线off_line离线 */
    @TableField("status")
    private String status;

    /** session创建时间 */
    @TableField("start_timestamp")
    private LocalDateTime startTimestamp;

    /** session最后访问时间 */
    @TableField("last_access_time")
    private LocalDateTime lastAccessTime;

    /** 超时时间，单位为分钟 */
    @TableField("expire_time")
    private Integer expireTime;
}
