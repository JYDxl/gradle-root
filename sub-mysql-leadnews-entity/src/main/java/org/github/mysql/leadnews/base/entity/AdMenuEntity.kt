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
 * 菜单资源信息表
 *
 * @author JYD_XL
 */
@TableName("ad_menu")
@ApiModel(value = "AdMenuEntity对象", description = "菜单资源信息表")
open class AdMenuEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 菜单名称 */
    @ApiModelProperty(value = "菜单名称")
    open var name: String? = null

    /** 菜单代码 */
    @ApiModelProperty(value = "菜单代码")
    open var code: String? = null

    /** 父菜单 */
    @ApiModelProperty(value = "父菜单")
    @TableField("parent_id")
    open var parentId: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val CODE : String = "code"

        const val PARENT_ID : String = "parent_id"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdMenuEntity{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", parentId=" + parentId +
        ", createdTime=" + createdTime +
        "}"
    }

}
