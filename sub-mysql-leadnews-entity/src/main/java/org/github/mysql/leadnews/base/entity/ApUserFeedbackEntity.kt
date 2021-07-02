package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * APP用户反馈信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_feedback")
@ApiModel(value = "ApUserFeedbackEntity对象", description = "APP用户反馈信息表")
open class ApUserFeedbackEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 发送人昵称 */
    @ApiModelProperty(value = "发送人昵称")
    @TableField("user_name")
    open var userName: String? = null

    /** 私信内容 */
    @ApiModelProperty(value = "私信内容")
    open var content: String? = null

    /** 反馈图片,多张逗号分隔 */
    @ApiModelProperty(value = "反馈图片,多张逗号分隔")
    open var images: String? = null

    /** 是否阅读 */
    @ApiModelProperty(value = "是否阅读")
    @TableField("is_solve")
    open var isSolve: Int? = null

    @TableField("solve_note")
    open var solveNote: String? = null

    /** 阅读时间 */
    @ApiModelProperty(value = "阅读时间")
    @TableField("solved_time")
    open var solvedTime: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val USER_NAME : String = "user_name"

        const val CONTENT : String = "content"

        const val IMAGES : String = "images"

        const val IS_SOLVE : String = "is_solve"

        const val SOLVE_NOTE : String = "solve_note"

        const val SOLVED_TIME : String = "solved_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return null
    }

    override fun toString(): String {
        return "ApUserFeedbackEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", content=" + content +
        ", images=" + images +
        ", isSolve=" + isSolve +
        ", solveNote=" + solveNote +
        ", solvedTime=" + solvedTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
