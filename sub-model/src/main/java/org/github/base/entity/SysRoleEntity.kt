package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_role")
class SysRoleEntity: AbstractEntity() {

    /** 角色ID */
    @TableId(value = "role_id", type = IdType.AUTO)
    var roleId: Long? = null

    /** 角色名称 */
    var roleName: String? = null

    /** 角色权限字符串 */
    var roleKey: String? = null

    /** 显示顺序 */
    var roleSort: Int? = null

    /** 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） */
    var dataScope: String? = null

    /** 角色状态（0正常 1停用） */
    var status: String? = null

    /** 删除标志（0代表存在 2代表删除） */
    var delFlag: String? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

    /** 备注 */
    var remark: String? = null

}
