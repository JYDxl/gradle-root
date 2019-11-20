package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_role_dept")
class SysRoleDeptEntity: AbstractEntity() {

    /** 角色ID */
    var roleId: Long? = null

    /** 部门ID */
    var deptId: Long? = null

}
