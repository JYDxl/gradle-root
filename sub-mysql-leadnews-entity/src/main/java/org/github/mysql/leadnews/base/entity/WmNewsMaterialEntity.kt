package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 自媒体图文引用素材信息表
 *
 * @author JYD_XL
 */
@TableName("wm_news_material")
@ApiModel(value = "WmNewsMaterialEntity对象", description = "自媒体图文引用素材信息表")
open class WmNewsMaterialEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 素材ID */
    @ApiModelProperty(value = "素材ID")
    @TableField("material_id")
    open var materialId: Int? = null

    /** 图文ID */
    @ApiModelProperty(value = "图文ID")
    @TableField("news_id")
    open var newsId: Int? = null

    /** 引用类型	            0 内容引用	            1 主图引用 */
    @ApiModelProperty(value = "引用类型	            0 内容引用	            1 主图引用")
    open var type: Int? = null

    /** 引用排序 */
    @ApiModelProperty(value = "引用排序")
    open var ord: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val MATERIAL_ID : String = "material_id"

        const val NEWS_ID : String = "news_id"

        const val TYPE : String = "type"

        const val ORD : String = "ord"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "WmNewsMaterialEntity{" +
        "id=" + id +
        ", materialId=" + materialId +
        ", newsId=" + newsId +
        ", type=" + type +
        ", ord=" + ord +
        "}"
    }

}
