@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 资源
 *
 * @author JYD_XL
 */
@TableName("resource")
@ApiModel("资源")
open class ResourceMbpPo : Entity() {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    @ApiModelProperty("名称|菜单或按钮")
    @TableField("name")
    open var name: String? = null

    @ApiModelProperty("页面|路由")
    @TableField("page")
    open var page: String? = null

    @ApiModelProperty("请求|接口")
    @TableField("request")
    open var request: String? = null

    @ApiModelProperty("父id")
    @TableField("parent")
    open var parent: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val NAME : String = "name"

        const val NAME_PROP : String = "name"

        const val PAGE : String = "page"

        const val PAGE_PROP : String = "page"

        const val REQUEST : String = "request"

        const val REQUEST_PROP : String = "request"

        const val PARENT : String = "parent"

        const val PARENT_PROP : String = "parent"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ResourceMbpPo) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (page != other.page) return false
        if (request != other.request) return false
        if (parent != other.parent) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (page?.hashCode() ?: 0)
        result = 31 * result + (request?.hashCode() ?: 0)
        result = 31 * result + (parent?.hashCode() ?: 0)
        return result
    }

}
