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
 * 访问数据统计表
 *
 * @author JYD_XL
 */
@TableName("ad_vistor_statistics")
@ApiModel(value = "AdVistorStatisticsEntity对象", description = "访问数据统计表")
open class AdVistorStatisticsEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 日活 */
    @ApiModelProperty(value = "日活")
    open var activity: Int? = null

    /** 访问量 */
    @ApiModelProperty(value = "访问量")
    open var vistor: Int? = null

    /** IP量 */
    @ApiModelProperty(value = "IP量")
    open var ip: Int? = null

    /** 注册量 */
    @ApiModelProperty(value = "注册量")
    open var register: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ACTIVITY : String = "activity"

        const val VISTOR : String = "vistor"

        const val IP : String = "ip"

        const val REGISTER : String = "register"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdVistorStatisticsEntity{" +
        "id=" + id +
        ", activity=" + activity +
        ", vistor=" + vistor +
        ", ip=" + ip +
        ", register=" + register +
        ", createdTime=" + createdTime +
        "}"
    }

}
