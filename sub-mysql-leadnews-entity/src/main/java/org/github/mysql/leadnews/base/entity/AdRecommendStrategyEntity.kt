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
 * 推荐策略信息表
 *
 * @author JYD_XL
 */
@TableName("ad_recommend_strategy")
@ApiModel(value = "AdRecommendStrategyEntity对象", description = "推荐策略信息表")
open class AdRecommendStrategyEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 策略名称 */
    @ApiModelProperty(value = "策略名称")
    open var name: String? = null

    /** 策略描述 */
    @ApiModelProperty(value = "策略描述")
    open var description: String? = null

    /** 是否有效 */
    @ApiModelProperty(value = "是否有效")
    @TableField("is_enable")
    open var isEnable: Boolean? = null

    /** 分组ID */
    @ApiModelProperty(value = "分组ID")
    @TableField("group_id")
    open var groupId: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val DESCRIPTION : String = "description"

        const val IS_ENABLE : String = "is_enable"

        const val GROUP_ID : String = "group_id"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdRecommendStrategyEntity{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", isEnable=" + isEnable +
        ", groupId=" + groupId +
        ", createdTime=" + createdTime +
        "}"
    }

}
