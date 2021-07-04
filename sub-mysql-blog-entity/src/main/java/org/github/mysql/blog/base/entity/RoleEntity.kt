package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_role")
@ApiModel(value = "RoleEntity对象", description = "")
open class RoleEntity : Entity() {

    /** 主键id */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 角色名 */
    @ApiModelProperty(value = "角色名")
    @TableField("role_name")
    open var roleName: String? = null

    /** 角色描述 */
    @ApiModelProperty(value = "角色描述")
    @TableField("role_label")
    open var roleLabel: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 是否禁用  0否 1是 */
    @ApiModelProperty(value = "是否禁用  0否 1是")
    @TableField("is_disable")
    open var isDisable: Boolean? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ROLE_NAME : String = "role_name"

        const val ROLE_LABEL : String = "role_label"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DISABLE : String = "is_disable"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "RoleEntity{" +
        "id=" + id +
        ", roleName=" + roleName +
        ", roleLabel=" + roleLabel +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDisable=" + isDisable +
        "}"
    }

}
