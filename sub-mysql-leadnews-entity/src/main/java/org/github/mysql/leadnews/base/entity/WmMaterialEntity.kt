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
 * 自媒体图文素材信息表
 *
 * @author JYD_XL
 */
@TableName("wm_material")
@ApiModel(value = "WmMaterialEntity对象", description = "自媒体图文素材信息表")
open class WmMaterialEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 自媒体用户ID */
    @ApiModelProperty(value = "自媒体用户ID")
    @TableField("user_id")
    open var userId: Int? = null

    /** 图片地址 */
    @ApiModelProperty(value = "图片地址")
    open var url: String? = null

    /** 素材类型	            0 图片	            1 视频 */
    @ApiModelProperty(value = "素材类型	            0 图片	            1 视频")
    open var type: Int? = null

    /** 是否收藏 */
    @ApiModelProperty(value = "是否收藏")
    @TableField("is_collection")
    open var isCollection: Boolean? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val URL : String = "url"

        const val TYPE : String = "type"

        const val IS_COLLECTION : String = "is_collection"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmMaterialEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", url=" + url +
        ", type=" + type +
        ", isCollection=" + isCollection +
        ", createdTime=" + createdTime +
        "}"
    }

}
