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
 * APP阅读行为表
 *
 * @author JYD_XL
 */
@TableName("ap_read_behavior")
@ApiModel(value = "ApReadBehaviorEntity对象", description = "APP阅读行为表")
open class ApReadBehaviorEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 文章ID */
    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    open var articleId: Int? = null

    open var count: Int? = null

    /** 阅读时间单位秒 */
    @ApiModelProperty(value = "阅读时间单位秒")
    @TableField("read_duration")
    open var readDuration: Int? = null

    /** 阅读百分比 */
    @ApiModelProperty(value = "阅读百分比")
    open var percentage: Int? = null

    /** 文章加载时间 */
    @ApiModelProperty(value = "文章加载时间")
    @TableField("load_duration")
    open var loadDuration: Int? = null

    /** 登录时间 */
    @ApiModelProperty(value = "登录时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    open var burst: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ENTRY_ID : String = "entry_id"

        const val ARTICLE_ID : String = "article_id"

        const val COUNT : String = "count"

        const val READ_DURATION : String = "read_duration"

        const val PERCENTAGE : String = "percentage"

        const val LOAD_DURATION : String = "load_duration"

        const val CREATED_TIME : String = "created_time"

        const val UPDATED_TIME : String = "updated_time"

        const val BURST : String = "burst"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApReadBehaviorEntity{" +
        "id=" + id +
        ", entryId=" + entryId +
        ", articleId=" + articleId +
        ", count=" + count +
        ", readDuration=" + readDuration +
        ", percentage=" + percentage +
        ", loadDuration=" + loadDuration +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        ", burst=" + burst +
        "}"
    }

}
