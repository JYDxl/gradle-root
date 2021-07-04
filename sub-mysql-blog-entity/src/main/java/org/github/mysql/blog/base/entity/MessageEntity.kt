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
@TableName("tb_message")
@ApiModel(value = "MessageEntity对象", description = "")
open class MessageEntity : Entity() {

    /** 主键id */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户ip */
    @ApiModelProperty(value = "用户ip")
    @TableField("ip_address")
    open var ipAddress: String? = null

    /** 用户地址 */
    @ApiModelProperty(value = "用户地址")
    @TableField("ip_source")
    open var ipSource: String? = null

    /** 昵称 */
    @ApiModelProperty(value = "昵称")
    open var nickname: String? = null

    /** 头像 */
    @ApiModelProperty(value = "头像")
    open var avatar: String? = null

    /** 留言内容 */
    @ApiModelProperty(value = "留言内容")
    @TableField("message_content")
    open var messageContent: String? = null

    /** 弹幕速度 */
    @ApiModelProperty(value = "弹幕速度")
    open var time: Boolean? = null

    /** 发布时间 */
    @ApiModelProperty(value = "发布时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val IP_ADDRESS : String = "ip_address"

        const val IP_SOURCE : String = "ip_source"

        const val NICKNAME : String = "nickname"

        const val AVATAR : String = "avatar"

        const val MESSAGE_CONTENT : String = "message_content"

        const val TIME : String = "time"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "MessageEntity{" +
        "id=" + id +
        ", ipAddress=" + ipAddress +
        ", ipSource=" + ipSource +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", messageContent=" + messageContent +
        ", time=" + time +
        ", createTime=" + createTime +
        "}"
    }

}
