@file:Suppress("UnusedImport", "unused")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 房源图片
 *
 * @author JYD_XL
 */
@TableName("hse_house_image")
open class HseHouseImageEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 房源id */
    @TableField("house_id")
    open var houseId: Long? = null

    /** 图片名称 */
    @TableField("image_name")
    open var imageName: String? = null

    /** 图片地址 */
    @TableField("image_url")
    open var imageUrl: String? = null

    /** 1：普通图片 2：房产图片 */
    @TableField("type")
    open var type: Byte? = null

    /** 创建时间 */
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 更新时间 */
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 删除标记（0:不可用 1:可用） */
    @TableField("is_deleted")
    open var isDeleted: Byte? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val HOUSE_ID : String = "house_id"

        const val IMAGE_NAME : String = "image_name"

        const val IMAGE_URL : String = "image_url"

        const val TYPE : String = "type"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "HseHouseImageEntity{" +
        "id=" + id +
        ", houseId=" + houseId +
        ", imageName=" + imageName +
        ", imageUrl=" + imageUrl +
        ", type=" + type +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
