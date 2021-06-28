package org.github.mysql.seata.storage.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 库存表
 *
 * @author JYD_XL
 */
@TableName("t_storage")
@ApiModel(value = "TStorageEntity对象", description = "库存表")
open class TStorageEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "storage_id", type = IdType.ASSIGN_ID)
    open var storageId: Long? = null

    /** 产品id */
    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    open var productId: Long? = null

    /** 总库存 */
    @ApiModelProperty(value = "总库存")
    open var total: Int? = null

    /** 已用库存 */
    @ApiModelProperty(value = "已用库存")
    open var used: Int? = null

    /** 剩余库存 */
    @ApiModelProperty(value = "剩余库存")
    open var residue: Int? = null

    override fun pkVal(): java.io.Serializable? {
        return storageId
    }

    override fun toString(): String {
        return "TStorageEntity{" +
        "storageId=" + storageId +
        ", productId=" + productId +
        ", total=" + total +
        ", used=" + used +
        ", residue=" + residue +
        "}"
    }

}
