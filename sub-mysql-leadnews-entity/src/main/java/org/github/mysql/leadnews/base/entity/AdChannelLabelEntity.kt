package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 频道标签信息表
 *
 * @author JYD_XL
 */
@TableName("ad_channel_label")
@ApiModel(value = "AdChannelLabelEntity对象", description = "频道标签信息表")
open class AdChannelLabelEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    @TableField("channel_id")
    open var channelId: Int? = null

    /** 标签ID */
    @ApiModelProperty(value = "标签ID")
    @TableField("label_id")
    open var labelId: Int? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    open var ord: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CHANNEL_ID : String = "channel_id"

        const val LABEL_ID : String = "label_id"

        const val ORD : String = "ord"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdChannelLabelEntity{" +
        "id=" + id +
        ", channelId=" + channelId +
        ", labelId=" + labelId +
        ", ord=" + ord +
        "}"
    }

}
