@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package org.github.mysql.blog.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import org.github.core.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("m_blog")
@ApiModel("")
open class BlogMbpPo : Entity() {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    @ApiModelProperty("用户id")
    @TableField("user_id")
    open var userId: Long? = null

    @ApiModelProperty("标题")
    @TableField("title")
    open var title: String? = null

    @ApiModelProperty("描述")
    @TableField("description")
    open var description: String? = null

    @ApiModelProperty("内容")
    @TableField("content")
    open var content: String? = null

    @ApiModelProperty("状态")
    @TableField("status")
    open var status: String? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ID_PROP : String = "id"

        const val USER_ID : String = "user_id"

        const val USER_ID_PROP : String = "userId"

        const val TITLE : String = "title"

        const val TITLE_PROP : String = "title"

        const val DESCRIPTION : String = "description"

        const val DESCRIPTION_PROP : String = "description"

        const val CONTENT : String = "content"

        const val CONTENT_PROP : String = "content"

        const val STATUS : String = "status"

        const val STATUS_PROP : String = "status"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BlogMbpPo) return false
        if (id != other.id) return false
        if (userId != other.userId) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (content != other.content) return false
        if (status != other.status) return false
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (userId?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }

}
