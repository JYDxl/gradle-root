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
@TableName("tb_menu")
@ApiModel(value = "MenuEntity对象", description = "")
open class MenuEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 菜单名 */
    @ApiModelProperty(value = "菜单名")
    open var name: String? = null

    /** 菜单路径 */
    @ApiModelProperty(value = "菜单路径")
    open var path: String? = null

    /** 组件 */
    @ApiModelProperty(value = "组件")
    open var component: String? = null

    /** 菜单icon */
    @ApiModelProperty(value = "菜单icon")
    open var icon: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    open var orderNum: Int? = null

    /** 父id */
    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    open var parentId: Int? = null

    /** 是否禁用 0否1是 */
    @ApiModelProperty(value = "是否禁用 0否1是")
    @TableField("is_disable")
    open var isDisable: Boolean? = null

    /** 是否隐藏  0否1是 */
    @ApiModelProperty(value = "是否隐藏  0否1是")
    @TableField("is_hidden")
    open var isHidden: Boolean? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val PATH : String = "path"

        const val COMPONENT : String = "component"

        const val ICON : String = "icon"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val ORDER_NUM : String = "order_num"

        const val PARENT_ID : String = "parent_id"

        const val IS_DISABLE : String = "is_disable"

        const val IS_HIDDEN : String = "is_hidden"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "MenuEntity{" +
        "id=" + id +
        ", name=" + name +
        ", path=" + path +
        ", component=" + component +
        ", icon=" + icon +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", orderNum=" + orderNum +
        ", parentId=" + parentId +
        ", isDisable=" + isDisable +
        ", isHidden=" + isHidden +
        "}"
    }

}
