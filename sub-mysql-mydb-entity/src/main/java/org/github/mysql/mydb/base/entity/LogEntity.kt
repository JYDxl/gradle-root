@file:Suppress("UnusedImport", "unused")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("log")
@ApiModel(value = "LogEntity对象", description = "")
open class LogEntity : Entity() {

    @TableField("info")
    open var info: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val INFO : String = "info"

    }

    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return "LogEntity{" +
        "info=" + info +
        "}"
    }

}
