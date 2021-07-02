package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP用户私信信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_letter")
@ApiModel(value = "ApUserLetterEntity对象", description = "APP用户私信信息表")
open class ApUserLetterEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 发送人ID */
    @ApiModelProperty(value = "发送人ID")
    @TableField("sender_id")
    open var senderId: Int? = null

    /** 发送人昵称 */
    @ApiModelProperty(value = "发送人昵称")
    @TableField("sender_name")
    open var senderName: String? = null

    /** 私信内容 */
    @ApiModelProperty(value = "私信内容")
    open var content: String? = null

    /** 是否阅读 */
    @ApiModelProperty(value = "是否阅读")
    @TableField("is_read")
    open var isRead: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 阅读时间 */
    @ApiModelProperty(value = "阅读时间")
    @TableField("read_time")
    open var readTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val SENDER_ID : String = "sender_id"

        const val SENDER_NAME : String = "sender_name"

        const val CONTENT : String = "content"

        const val IS_READ : String = "is_read"

        const val CREATED_TIME : String = "created_time"

        const val READ_TIME : String = "read_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return null
    }

    override fun toString(): String {
        return "ApUserLetterEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", senderId=" + senderId +
        ", senderName=" + senderName +
        ", content=" + content +
        ", isRead=" + isRead +
        ", createdTime=" + createdTime +
        ", readTime=" + readTime +
        "}"
    }

}
