@file:Suppress("UnusedImport", "unused")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 房源表
 *
 * @author JYD_XL
 */
@TableName("hse_house")
open class HseHouseEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 小区id */
    @TableField("community_id")
    open var communityId: Long? = null

    /** 房源名称 */
    @TableField("name")
    open var name: String? = null

    /** 描述 */
    @TableField("description")
    open var description: String? = null

    /** 总价：万元 */
    @TableField("total_price")
    open var totalPrice: BigDecimal? = null

    /** 单位价格 */
    @TableField("unit_price")
    open var unitPrice: BigDecimal? = null

    /** 建筑面积 */
    @TableField("build_area")
    open var buildArea: BigDecimal? = null

    /** 套内面积 */
    @TableField("inside_area")
    open var insideArea: BigDecimal? = null

    /** 户型：（字典id） */
    @TableField("house_type_id")
    open var houseTypeId: String? = null

    /** 楼层（字典id） */
    @TableField("floor_id")
    open var floorId: Long? = null

    /** 建筑结构：（字典id） */
    @TableField("build_structure_id")
    open var buildStructureId: Long? = null

    /** 朝向：（字典id） */
    @TableField("direction_id")
    open var directionId: Long? = null

    /** 装修情况：（字典id） */
    @TableField("decoration_id")
    open var decorationId: Long? = null

    /** 房屋用途：（字典id） */
    @TableField("house_use_id")
    open var houseUseId: Long? = null

    /** 电梯比例 */
    @TableField("elevator_ratio")
    open var elevatorRatio: String? = null

    /** 挂牌日期 */
    @TableField("listing_date")
    open var listingDate: LocalDate? = null

    /** 上次交易日期 */
    @TableField("last_trade_date")
    open var lastTradeDate: LocalDate? = null

    /** 默认图片 */
    @TableField("default_image_url")
    open var defaultImageUrl: String? = null

    /** 状态 */
    @TableField("status")
    open var status: Byte? = null

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

        const val COMMUNITY_ID : String = "community_id"

        const val NAME : String = "name"

        const val DESCRIPTION : String = "description"

        const val TOTAL_PRICE : String = "total_price"

        const val UNIT_PRICE : String = "unit_price"

        const val BUILD_AREA : String = "build_area"

        const val INSIDE_AREA : String = "inside_area"

        const val HOUSE_TYPE_ID : String = "house_type_id"

        const val FLOOR_ID : String = "floor_id"

        const val BUILD_STRUCTURE_ID : String = "build_structure_id"

        const val DIRECTION_ID : String = "direction_id"

        const val DECORATION_ID : String = "decoration_id"

        const val HOUSE_USE_ID : String = "house_use_id"

        const val ELEVATOR_RATIO : String = "elevator_ratio"

        const val LISTING_DATE : String = "listing_date"

        const val LAST_TRADE_DATE : String = "last_trade_date"

        const val DEFAULT_IMAGE_URL : String = "default_image_url"

        const val STATUS : String = "status"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "HseHouseEntity{" +
        "id=" + id +
        ", communityId=" + communityId +
        ", name=" + name +
        ", description=" + description +
        ", totalPrice=" + totalPrice +
        ", unitPrice=" + unitPrice +
        ", buildArea=" + buildArea +
        ", insideArea=" + insideArea +
        ", houseTypeId=" + houseTypeId +
        ", floorId=" + floorId +
        ", buildStructureId=" + buildStructureId +
        ", directionId=" + directionId +
        ", decorationId=" + decorationId +
        ", houseUseId=" + houseUseId +
        ", elevatorRatio=" + elevatorRatio +
        ", listingDate=" + listingDate +
        ", lastTradeDate=" + lastTradeDate +
        ", defaultImageUrl=" + defaultImageUrl +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}"
    }

}
