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
 * APP用户频道信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_channel")
@ApiModel(value = "ApUserChannelEntity对象", description = "APP用户频道信息表")
open class ApUserChannelEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("channel_id")
    open var channelId: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("user_id")
    open var userId: Int? = null

    open var name: String? = null

    /** 频道排序 */
    @ApiModelProperty(value = "频道排序")
    open var ord: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CHANNEL_ID : String = "channel_id"

        const val USER_ID : String = "user_id"

        const val NAME : String = "name"

        const val ORD : String = "ord"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserChannelEntity{" +
        "id=" + id +
        ", channelId=" + channelId +
        ", userId=" + userId +
        ", name=" + name +
        ", ord=" + ord +
        ", createdTime=" + createdTime +
        "}"
    }

}
