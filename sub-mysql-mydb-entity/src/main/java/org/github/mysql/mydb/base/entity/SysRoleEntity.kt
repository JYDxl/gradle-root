package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 角色表
 *
 * @author JYD_XL
 */
@TableName("sys_role")
@ApiModel(value = "SysRoleEntity对象", description = "角色表")
open class SysRoleEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
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
    open var remark: String? = null

    /** 创建者ID */
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_user_id")
    open var createUserId: Long? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    open var createTime: LocalDateTime? = null

    override fun pkVal(): java.io.Serializable? {
        return roleId
    }

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
