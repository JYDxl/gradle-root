package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 自媒体子账号权限信息表
 *
 * @author JYD_XL
 */
@TableName("wm_user_auth")
@ApiModel(value = "WmUserAuthEntity对象", description = "自媒体子账号权限信息表")
open class WmUserAuthEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 账号ID */
    @ApiModelProperty(value = "账号ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 资源类型	            0 菜单	            1 频道	            2 按钮 */
    @ApiModelProperty(value = "资源类型	            0 菜单	            1 频道	            2 按钮")
    open var type: Int? = null

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称")
    open var name: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val TYPE : String = "type"

        const val NAME : String = "name"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmUserAuthEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", type=" + type +
        ", name=" + name +
        "}"
    }

}
