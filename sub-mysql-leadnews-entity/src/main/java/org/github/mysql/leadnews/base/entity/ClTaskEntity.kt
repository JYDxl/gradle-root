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
 * 爬虫任务信息表
 *
 * @author JYD_XL
 */
@TableName("cl_task")
@ApiModel(value = "ClTaskEntity对象", description = "爬虫任务信息表")
open class ClTaskEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 供应商 */
    @ApiModelProperty(value = "供应商")
    open var name: String? = null

    /** 任务代码 */
    @ApiModelProperty(value = "任务代码")
    open var code: String? = null

    /** cron表达式 */
    @ApiModelProperty(value = "cron表达式")
    open var cron: String? = null

    /** 完全限定名 */
    @ApiModelProperty(value = "完全限定名")
    @TableField("bean_name")
    open var beanName: String? = null

    /** 方法名称 */
    @ApiModelProperty(value = "方法名称")
    open var method: String? = null

    /** 任务间隔(S) */
    @ApiModelProperty(value = "任务间隔(S)")
    @TableField("interval_time")
    open var intervalTime: Int? = null

    /** 是否有效 */
    @ApiModelProperty(value = "是否有效")
    @TableField("is_enable")
    open var isEnable: Int? = null

    /** 最后运行时间 */
    @ApiModelProperty(value = "最后运行时间")
    @TableField("last_time")
    open var lastTime: LocalDateTime? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val CODE : String = "code"

        const val CRON : String = "cron"

        const val BEAN_NAME : String = "bean_name"

        const val METHOD : String = "method"

        const val INTERVAL_TIME : String = "interval_time"

        const val IS_ENABLE : String = "is_enable"

        const val LAST_TIME : String = "last_time"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ClTaskEntity{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", cron=" + cron +
        ", beanName=" + beanName +
        ", method=" + method +
        ", intervalTime=" + intervalTime +
        ", isEnable=" + isEnable +
        ", lastTime=" + lastTime +
        ", createdTime=" + createdTime +
        "}"
    }

}
