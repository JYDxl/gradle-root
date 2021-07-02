package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 自媒体子账号信息表
 *
 * @author JYD_XL
 */
@TableName("wm_sub_user")
@ApiModel(value = "WmSubUserEntity对象", description = "自媒体子账号信息表")
open class WmSubUserEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 主账号ID */
    @ApiModelProperty(value = "主账号ID")
    @TableField("parent_id")
    open var parentId: Int? = null

    /** 子账号ID */
    @ApiModelProperty(value = "子账号ID")
    @TableField("children_id")
    open var childrenId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val PARENT_ID : String = "parent_id"

        const val CHILDREN_ID : String = "children_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmSubUserEntity{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", childrenId=" + childrenId +
        "}"
    }

}
