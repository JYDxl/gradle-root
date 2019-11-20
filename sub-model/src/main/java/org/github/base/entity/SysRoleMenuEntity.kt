package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_role_menu")
class SysRoleMenuEntity: AbstractEntity() {

    /** 角色ID */
    var roleId: Long? = null

    /** 菜单ID */
    var menuId: Long? = null

}
