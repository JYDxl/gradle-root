@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.entity

import java.time.LocalDateTime
import com.baomidou.mybatisplus.annotation.*
import org.github.base.IEntity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 角色
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@TableName("sys_role")
@ApiModel(value="SysRoleEntity对象", description="角色")
open class SysRoleEntity : IEntity() {

    @TableId(value = "role_id", type = IdType.AUTO)
    open var roleId: Long? = null

    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    open var roleName: String? = null

    @ApiModelProperty(value = "角色编码")
    @TableField("role_code")
    open var roleCode: String? = null

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    open var remark: String? = null

    @ApiModelProperty(value = "创建者ID")
    @TableField("create_user_id")
    open var createUserId: Long? = null

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
