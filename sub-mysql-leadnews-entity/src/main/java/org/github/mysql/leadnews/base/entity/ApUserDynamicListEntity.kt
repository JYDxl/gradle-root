package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP用户动态列表
 *
 * @author JYD_XL
 */
@TableName("ap_user_dynamic_list")
@ApiModel(value = "ApUserDynamicListEntity对象", description = "APP用户动态列表")
open class ApUserDynamicListEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 动态ID */
    @ApiModelProperty(value = "动态ID")
    @TableField("dynamic_id")
    open var dynamicId: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val DYNAMIC_ID : String = "dynamic_id"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserDynamicListEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", dynamicId=" + dynamicId +
        "}"
    }

}
