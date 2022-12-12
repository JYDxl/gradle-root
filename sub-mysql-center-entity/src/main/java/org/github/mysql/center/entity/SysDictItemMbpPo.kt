@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.Version
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 码值条目
 *
 * @author JYD_XL
 */
@TableName("t_sys_dict_item")
@ApiModel("码值条目")
open class SysDictItemMbpPo : Entity() {

    @ApiModelProperty("")
    @TableField("dict_code")
    open var dictCode: String? = null

    @ApiModelProperty("")
    @TableField("item_code")
    open var itemCode: String? = null

    @ApiModelProperty("")
    @TableField("item_name")
    open var itemName: String? = null

    @ApiModelProperty("")
    @TableField("item_info")
    open var itemInfo: String? = null

    @ApiModelProperty("")
    @TableField("sort")
    open var sort: Int? = null

    @ApiModelProperty("")
    @TableField("revision")
    @Version
    open var revision: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val DICT_CODE : String = "dict_code"

        const val ITEM_CODE : String = "item_code"

        const val ITEM_NAME : String = "item_name"

        const val ITEM_INFO : String = "item_info"

        const val SORT : String = "sort"

        const val REVISION : String = "revision"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SysDictItemMbpPo) return false
        if (dictCode != other.dictCode) return false
        if (itemCode != other.itemCode) return false
        if (itemName != other.itemName) return false
        if (itemInfo != other.itemInfo) return false
        if (sort != other.sort) return false
        if (revision != other.revision) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (dictCode?.hashCode() ?: 0)
        result = 31 * result + (itemCode?.hashCode() ?: 0)
        result = 31 * result + (itemName?.hashCode() ?: 0)
        result = 31 * result + (itemInfo?.hashCode() ?: 0)
        result = 31 * result + (sort?.hashCode() ?: 0)
        result = 31 * result + (revision?.hashCode() ?: 0)
        return result
    }

}
