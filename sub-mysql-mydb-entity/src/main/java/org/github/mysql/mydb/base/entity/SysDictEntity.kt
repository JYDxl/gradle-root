@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.Version
import java.io.Serializable
import org.github.base.Entity

/**
 * 字典总表
 *
 * @author JYD_XL
 */
@TableName("sys_dict")
open class SysDictEntity : Entity() {

    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Long? = null

    /** 字典类别 */
    @TableField("name")
    open var name: String? = null

    /** 字典标签 */
    @TableField("label")
    open var label: String? = null

    /** 字典介绍 */
    @TableField("intro")
    open var intro: String? = null

    /** 码值【排序值】 */
    @TableField("code")
    open var code: Int? = null

    /** 当前版本 */
    @TableField("version")
    @Version
    open var version: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val LABEL : String = "label"

        const val INTRO : String = "intro"

        const val CODE : String = "code"

        const val VERSION : String = "version"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysDictEntity{" +
        "id=" + id +
        ", name=" + name +
        ", label=" + label +
        ", intro=" + intro +
        ", code=" + code +
        ", version=" + version +
        "}"
    }

}
