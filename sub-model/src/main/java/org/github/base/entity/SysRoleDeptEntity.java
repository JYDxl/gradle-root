package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_dept")
public class SysRoleDeptEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    @TableId("role_id")
    private Long roleId;

    /** 部门ID */
    @TableField("dept_id")
    private Long deptId;
}
