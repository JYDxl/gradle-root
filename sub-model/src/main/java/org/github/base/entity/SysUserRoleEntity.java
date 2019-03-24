package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sys_user_role_table
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-24
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
    private String userId;

    /** role_id */
    private String roleId;

    /** delete flag */
    @TableLogic
    private Integer deleted;

}
