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
 * 爬取异常信息表
 *
 * @author JYD_XL
 */
@TableName("cl_task_exception")
@ApiModel(value = "ClTaskExceptionEntity对象", description = "爬取异常信息表")
open class ClTaskExceptionEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 任务ID */
    @ApiModelProperty(value = "任务ID")
    @TableField("task_id")
    open var taskId: Int? = null

    /** 任务批次 */
    @ApiModelProperty(value = "任务批次")
    open var no: Int? = null

    /** 源网页地址 */
    @ApiModelProperty(value = "源网页地址")
    open var url: String? = null

    /** 爬取内容 */
    @ApiModelProperty(value = "爬取内容")
    open var content: String? = null

    /** 异常类型	            0 验证码异常	            1 字体异常 */
    @ApiModelProperty(value = "异常类型	            0 验证码异常	            1 字体异常")
    open var type: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TASK_ID : String = "task_id"

        const val NO : String = "no"

        const val URL : String = "url"

        const val CONTENT : String = "content"

        const val TYPE : String = "type"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClTaskExceptionEntity{" +
        "id=" + id +
        ", taskId=" + taskId +
        ", no=" + no +
        ", url=" + url +
        ", content=" + content +
        ", type=" + type +
        ", createdTime=" + createdTime +
        "}"
    }

}
