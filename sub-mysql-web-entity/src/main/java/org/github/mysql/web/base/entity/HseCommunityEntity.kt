@file:Suppress("UnusedImport", "unused")

package org.github.mysql.web.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import org.github.base.Entity

/**
 * 小区信息
 *
 * @author JYD_XL
 */
@TableName("hse_community")
open class HseCommunityEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 小区名称 */
    @TableField("name")
    open var name: String? = null

    /** 描述 */
    @TableField("description")
    open var description: String? = null

    /** 省id：（字典id） 预留字段 */
    @TableField("province_id")
    open var provinceId: Long? = null

    /** 城市id：（字典id）预留字段 */
    @TableField("city_id")
    open var cityId: Long? = null

    /** 区域id：（字典id） */
    @TableField("area_id")
    open var areaId: Long? = null

    /** 板块id：（字典id） */
    @TableField("plate_id")
    open var plateId: Long? = null

    /** 详细地址 */
    @TableField("address")
    open var address: String? = null

    /** 经度（预留字段） */
    @TableField("longitude")
    open var longitude: BigDecimal? = null

    /** 纬度（预留字段） */
    @TableField("latitude")
    open var latitude: BigDecimal? = null

    /** 建筑年代 */
    @TableField("build_years")
    open var buildYears: String? = null

    /** 物业价格 */
    @TableField("property_price")
    open var propertyPrice: String? = null

    /** 物业公司 */
    @TableField("property_company")
    open var propertyCompany: String? = null

    /** 开发商 */
    @TableField("developer")
    open var developer: String? = null

    /** 楼栋数 */
    @TableField("build_num")
    open var buildNum: Int? = null

    /** 房屋数 */
    @TableField("house_num")
    open var houseNum: Int? = null

    /** 均价 */
    @TableField("average_price")
    open var averagePrice: BigDecimal? = null

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

        const val NAME : String = "name"

        const val DESCRIPTION : String = "description"

        const val PROVINCE_ID : String = "province_id"

        const val CITY_ID : String = "city_id"

        const val AREA_ID : String = "area_id"

        const val PLATE_ID : String = "plate_id"

        const val ADDRESS : String = "address"

        const val LONGITUDE : String = "longitude"

        const val LATITUDE : String = "latitude"

        const val BUILD_YEARS : String = "build_years"

        const val PROPERTY_PRICE : String = "property_price"

        const val PROPERTY_COMPANY : String = "property_company"

        const val DEVELOPER : String = "developer"

        const val BUILD_NUM : String = "build_num"

        const val HOUSE_NUM : String = "house_num"

        const val AVERAGE_PRICE : String = "average_price"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DELETED : String = "is_deleted"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
