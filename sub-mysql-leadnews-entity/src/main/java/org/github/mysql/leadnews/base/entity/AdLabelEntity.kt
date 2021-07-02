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
 * 标签信息表
 *
 * @author JYD_XL
 */
@TableName("ad_label")
@ApiModel(value = "AdLabelEntity对象", description = "标签信息表")
open class AdLabelEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 频道名称 */
    @ApiModelProperty(value = "频道名称")
    open var name: String? = null

    /** 0系统增加	            1人工增加 */
    @ApiModelProperty(value = "0系统增加	            1人工增加")
    open var type: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val TYPE : String = "type"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdLabelEntity{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", createdTime=" + createdTime +
        "}"
    }

}
