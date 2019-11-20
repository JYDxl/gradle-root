package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_user_role")
class SysUserRoleEntity: AbstractEntity() {

    /** 用户ID */
    var userId: Long? = null

    /** 角色ID */
    var roleId: Long? = null

}
