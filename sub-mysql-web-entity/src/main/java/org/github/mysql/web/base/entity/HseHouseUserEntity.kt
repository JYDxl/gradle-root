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
 * 房东信息表
 *
 * @author JYD_XL
 */
@TableName("hse_house_user")
open class HseHouseUserEntity : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 房源id */
    @TableField("house_id")
    open var houseId: Long? = null

    /** 房东姓名 */
    @TableField("name")
    open var name: String? = null

    /** 手机 */
    @TableField("phone")
    open var phone: String? = null

    /** 性别 1:男 2：女 */
    @TableField("sex")
    open var sex: Byte? = null

    /** 身份证号 */
    @TableField("id_no")
    open var idNo: String? = null

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

        const val NAME : String = "name"

        const val PHONE : String = "phone"

        const val SEX : String = "sex"

        const val ID_NO : String = "id_no"

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
