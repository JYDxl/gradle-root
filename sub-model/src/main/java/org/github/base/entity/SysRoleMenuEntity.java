package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统-角色菜单关系表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends AbstractEntity {

    /** UID */
    private static final long serialVersionUID = 1L;

    /** 角色菜单关系ID */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /** 角色ID */
    private String roleId;

    /** 菜单ID */
    private String menuId;

    /** 删除标志 */
    @TableLogic
    private Integer deleted;

}
