package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 用户与岗位关联表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_user_post")
class SysUserPostEntity: AbstractEntity() {

    /** 用户ID */
    var userId: Long? = null

    /** 岗位ID */
    var postId: Long? = null

}
