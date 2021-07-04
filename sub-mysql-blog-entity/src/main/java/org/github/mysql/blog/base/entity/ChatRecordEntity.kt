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
@TableName("tb_chat_record")
@ApiModel(value = "ChatRecordEntity对象", description = "")
open class ChatRecordEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Int? = null

    /** 昵称 */
    @ApiModelProperty(value = "昵称")
    open var nickname: String? = null

    /** 头像 */
    @ApiModelProperty(value = "头像")
    open var avatar: String? = null

    /** 聊天内容 */
    @ApiModelProperty(value = "聊天内容")
    open var content: String? = null

    /** ip地址 */
    @ApiModelProperty(value = "ip地址")
    @TableField("ip_addr")
    open var ipAddr: String? = null

    /** ip来源 */
    @ApiModelProperty(value = "ip来源")
    @TableField("ip_source")
    open var ipSource: String? = null

    /** 类型 */
    @ApiModelProperty(value = "类型")
    open var type: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val NICKNAME : String = "nickname"

        const val AVATAR : String = "avatar"

        const val CONTENT : String = "content"

        const val IP_ADDR : String = "ip_addr"

        const val IP_SOURCE : String = "ip_source"

        const val TYPE : String = "type"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ChatRecordEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", content=" + content +
        ", ipAddr=" + ipAddr +
        ", ipSource=" + ipSource +
        ", type=" + type +
        ", createTime=" + createTime +
        "}"
    }

}
