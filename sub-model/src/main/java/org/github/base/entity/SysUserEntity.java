package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统-用户表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    /** 用户编号 */
    private String userCode;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 用户状态 1：启用 */
    private Boolean state;

    /** salt */
    private String salt;

    /** 是否为系统用户 */
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

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private LocalDateTime createdAt;

    /** 更新时间 */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    /** 删除标志 */
    @TableLogic
    private Integer deleted;

}
