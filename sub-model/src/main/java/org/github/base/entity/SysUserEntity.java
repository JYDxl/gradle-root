package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_user_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    /** 用户编号 */
    private String userCode;

    /** username */
    private String username;

    /** password */
    private String password;

    /** state */
    private Boolean state;

    /** salt */
    private String salt;

    /** is_system */
    private Boolean isSystem;

    /** 姓名 */
    private String personName;

    /** 所属组织 */
    private String orgId;

    /** 性别 */
    private String sex;

    /** 地址 */
    private String address;

    /** 出生日期 */
    private LocalDate birthday;

    /** 学历 */
    private String edu;

    /** 用户类型，正常用户、临时用户 */
    private String userType;

    /** 手机号、电话号码 */
    private String mobile;

    /** 用户邮箱 */
    private String userEmail;

    /** 身份证号码 */
    private String idcard;

    /** 允许登录的IP区间，多个用,分割 */
    private String ipRange;

    /** 失效日期 */
    private LocalDate expiryDate;

    /** remark */
    private String remark;

    /** create_time */
    private LocalDateTime createdAt;

    /** update_time */
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableLogic
    private Integer deleted;

}
