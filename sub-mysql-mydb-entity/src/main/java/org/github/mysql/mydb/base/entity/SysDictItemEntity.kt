package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 字典明细表
 *
 * @author JYD_XL
 */
@TableName("sys_dict_item")
@ApiModel(value = "SysDictItemEntity对象", description = "字典明细表")
open class SysDictItemEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 字典类别 */
    @ApiModelProperty(value = "字典类别")
    @TableField("dict_name")
    open var dictName: String? = null

    /** 字典明细类别 */
    @ApiModelProperty(value = "字典明细类别")
    @TableField("name")
    open var name: String? = null

    /** 字典明细标签 */
    @ApiModelProperty(value = "字典明细标签")
    @TableField("label")
    open var label: String? = null

    /** 字典明细介绍 */
    @ApiModelProperty(value = "字典明细介绍")
    @TableField("intro")
    open var intro: String? = null

    /** 排序码 */
    @ApiModelProperty(value = "排序码")
    @TableField("sort")
    open var sort: Int? = null

    /** 当前版本 */
    @ApiModelProperty(value = "当前版本")
    @TableField("version")
    open var version: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val DICT_NAME : String = "dict_name"

        const val NAME : String = "name"

        const val LABEL : String = "label"

        const val INTRO : String = "intro"

        const val SORT : String = "sort"

        const val VERSION : String = "version"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysDictItemEntity{" +
        "id=" + id +
        ", dictName=" + dictName +
        ", name=" + name +
        ", label=" + label +
        ", intro=" + intro +
        ", sort=" + sort +
        ", version=" + version +
        "}"
    }

}
