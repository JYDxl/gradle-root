package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP用户消息通知信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_message")
@ApiModel(value = "ApUserMessageEntity对象", description = "APP用户消息通知信息表")
open class ApUserMessageEntity : Entity() {

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

    /** 消息类型	            0 关注	            1 取消关注	            2 点赞文章	            3 取消点赞文章	            4 转发文章	            5 收藏文章	            6 点赞评论	            7 审核通过评论	            8 私信通知	            9 评论通知	            10 分享通知	            	            100 身份证审核通过	            101 身份证审核拒绝	            102 实名认证通过	            103 实名认证失败	            104 自媒体人祝贺	            105 异常登录通知	            106 反馈回复	            107 转发通知 */
    @ApiModelProperty(value = "消息类型	            0 关注	            1 取消关注	            2 点赞文章	            3 取消点赞文章	            4 转发文章	            5 收藏文章	            6 点赞评论	            7 审核通过评论	            8 私信通知	            9 评论通知	            10 分享通知	            	            100 身份证审核通过	            101 身份证审核拒绝	            102 实名认证通过	            103 实名认证失败	            104 自媒体人祝贺	            105 异常登录通知	            106 反馈回复	            107 转发通知")
    open var type: Int? = null

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

        const val TYPE : String = "type"

        const val IS_READ : String = "is_read"

        const val CREATED_TIME : String = "created_time"

        const val READ_TIME : String = "read_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return null
    }

    override fun toString(): String {
        return "ApUserMessageEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", senderId=" + senderId +
        ", senderName=" + senderName +
        ", content=" + content +
        ", type=" + type +
        ", isRead=" + isRead +
        ", createdTime=" + createdTime +
        ", readTime=" + readTime +
        "}"
    }

}