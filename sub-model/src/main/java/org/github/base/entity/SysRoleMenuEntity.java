package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    @TableId(value = "role_id", type = IdType.ASSIGN_UUID)
    private Long roleId;

    /** 菜单ID */
    @TableField("menu_id")
    private Long menuId;
}
