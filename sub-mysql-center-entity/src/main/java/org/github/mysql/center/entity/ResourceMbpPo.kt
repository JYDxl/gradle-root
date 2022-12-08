@file:Suppress("UnusedImport", "unused")

package org.github.mysql.center.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity

/**
 * 资源
 *
 * @author JYD_XL
 */
@TableName("resource")
open class ResourceMbpPo : Entity() {

    /** id */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 名称|菜单或按钮 */
    @TableField("name")
    open var name: String? = null

    /** 页面|路由 */
    @TableField("page")
    open var page: String? = null

    /** 请求|接口 */
    @TableField("request")
    open var request: String? = null

    /** 父id */
    @TableField("parent")
    open var parent: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val NAME : String = "name"

        const val PAGE : String = "page"

        const val REQUEST : String = "request"

        const val PARENT : String = "parent"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

}
