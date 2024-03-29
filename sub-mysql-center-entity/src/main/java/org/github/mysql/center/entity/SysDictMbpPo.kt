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
 * 码值类型
 *
 * @author JYD_XL
 */
@TableName("t_sys_dict")
@ApiModel("码值类型")
open class SysDictMbpPo : Entity() {

    @ApiModelProperty("")
    @TableField("dict_code")
    open var dictCode: String? = null

    @ApiModelProperty("")
    @TableField("dict_name")
    open var dictName: String? = null

    @ApiModelProperty("")
    @TableField("dict_info")
    open var dictInfo: String? = null

    @ApiModelProperty("")
    @TableField("revision")
    @Version
    open var revision: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val DICT_CODE : String = "dict_code"

        const val DICT_CODE_PROP : String = "dictCode"

        const val DICT_NAME : String = "dict_name"

        const val DICT_NAME_PROP : String = "dictName"

        const val DICT_INFO : String = "dict_info"

        const val DICT_INFO_PROP : String = "dictInfo"

        const val REVISION : String = "revision"

        const val REVISION_PROP : String = "revision"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SysDictMbpPo) return false
        if (dictCode != other.dictCode) return false
        if (dictName != other.dictName) return false
        if (dictInfo != other.dictInfo) return false
        if (revision != other.revision) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (dictCode?.hashCode() ?: 0)
        result = 31 * result + (dictName?.hashCode() ?: 0)
        result = 31 * result + (dictInfo?.hashCode() ?: 0)
        result = 31 * result + (revision?.hashCode() ?: 0)
        return result
    }

}
