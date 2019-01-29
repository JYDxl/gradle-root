package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_user_role_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /** user_id */
    @TableField("user_id")
    private String userId;

    /** role_id */
    @TableField("role_id")
    private String roleId;

    /** delete flag */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /** update version */
    @TableField("version")
    @Version
    private Integer version;

}
