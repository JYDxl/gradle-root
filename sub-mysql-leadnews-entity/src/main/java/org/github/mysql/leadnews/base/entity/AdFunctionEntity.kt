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
 * 页面功能信息表
 *
 * @author JYD_XL
 */
@TableName("ad_function")
@ApiModel(value = "AdFunctionEntity对象", description = "页面功能信息表")
open class AdFunctionEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 功能名称 */
    @ApiModelProperty(value = "功能名称")
    open var name: String? = null

    /** 功能代码 */
    @ApiModelProperty(value = "功能代码")
    open var code: String? = null

    /** 父功能 */
    @ApiModelProperty(value = "父功能")
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
        return "AdFunctionEntity{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", parentId=" + parentId +
        ", createdTime=" + createdTime +
        "}"
    }

}
