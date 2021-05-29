@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import java.time.LocalDateTime
import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@TableName("sys_role")
@ApiModel(value="SysRoleEntity对象", description="角色")
open class SysRoleEntity : IEntity() {

    @TableId(value = "role_id", type = IdType.AUTO)
    open var roleId: Long? = null

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    open var roleName: String? = null

    /** 角色编码 */
    @ApiModelProperty(value = "角色编码")
    @TableField("role_code")
    open var roleCode: String? = null

    /** 备注 */
    @ApiModelProperty(value = "备注")
    @TableField("remark")
    open var remark: String? = null

    /** 创建者ID */
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_user_id")
    open var createUserId: Long? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    override fun toString(): String {
        return "SysRoleEntity{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleCode=" + roleCode +
        ", remark=" + remark +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        "}"
    }

}
