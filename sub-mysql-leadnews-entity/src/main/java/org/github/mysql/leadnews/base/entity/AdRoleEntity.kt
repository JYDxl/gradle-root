package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 角色信息表
 *
 * @author JYD_XL
 */
@TableName("ad_role")
@ApiModel(value = "AdRoleEntity对象", description = "角色信息表")
open class AdRoleEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    open var name: String? = null

    /** 角色描述 */
    @ApiModelProperty(value = "角色描述")
    open var description: String? = null

    /** 是否有效 */
    @ApiModelProperty(value = "是否有效")
    @TableField("is_enable")
    open var isEnable: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val DESCRIPTION : String = "description"

        const val IS_ENABLE : String = "is_enable"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdRoleEntity{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", isEnable=" + isEnable +
        ", createdTime=" + createdTime +
        "}"
    }

}
