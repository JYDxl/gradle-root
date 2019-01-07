package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_user_role_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** user_id */
    private String userId;

    /** role_id */
    private String roleId;

    /** ID */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

}
