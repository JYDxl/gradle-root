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
 * 自媒体粉丝画像信息表
 *
 * @author JYD_XL
 */
@TableName("wm_fans_portrait")
@ApiModel(value = "WmFansPortraitEntity对象", description = "自媒体粉丝画像信息表")
open class WmFansPortraitEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 账号ID */
    @ApiModelProperty(value = "账号ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 画像项目 */
    @ApiModelProperty(value = "画像项目")
    open var name: String? = null

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称")
    open var value: String? = null

    open var burst: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val NAME : String = "name"

        const val VALUE : String = "value"

        const val BURST : String = "burst"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmFansPortraitEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", value=" + value +
        ", burst=" + burst +
        ", createdTime=" + createdTime +
        "}"
    }

}
