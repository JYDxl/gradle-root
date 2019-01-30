package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * sys_user_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-30
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
    @TableField("user_code")
    private String userCode;

    /** username */
    @TableField("username")
    private String username;

    /** password */
    @TableField("password")
    private String password;

    /** state */
    @TableField("state")
    private Boolean state;

    /** salt */
    @TableField("salt")
    private String salt;

    /** is_system */
    @TableField("is_system")
    private Boolean isSystem;

    /** 姓名 */
    @TableField("person_name")
    private String personName;

    /** 所属组织 */
    @TableField("org_id")
    private String orgId;

    /** 性别 */
    @TableField("sex")
    private String sex;

    /** 地址 */
    @TableField("address")
    private String address;

    /** 出生日期 */
    @TableField("birthday")
    private LocalDate birthday;

    /** 学历 */
    @TableField("edu")
    private String edu;

    /** 用户类型，正常用户、临时用户 */
    @TableField("user_type")
    private String userType;

    /** 手机号、电话号码 */
    @TableField("mobile")
    private String mobile;

    /** 用户邮箱 */
    @TableField("user_email")
    private String userEmail;

    /** 身份证号码 */
    @TableField("idcard")
    private String idcard;

    /** 允许登录的IP区间，多个用,分割 */
    @TableField("ip_range")
    private String ipRange;

    /** 失效日期 */
    @TableField("expiry_date")
    private LocalDate expiryDate;

    /** remark */
    @TableField("remark")
    private String remark;

    /** create_time */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /** update_time */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
