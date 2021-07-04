package org.github.mysql.blog.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("tb_resource")
@ApiModel(value = "ResourceEntity对象", description = "")
open class ResourceEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 资源名 */
    @ApiModelProperty(value = "资源名")
    @TableField("resource_name")
    open var resourceName: String? = null

    /** 权限路径 */
    @ApiModelProperty(value = "权限路径")
    open var url: String? = null

    /** 请求方式 */
    @ApiModelProperty(value = "请求方式")
    @TableField("request_method")
    open var requestMethod: String? = null

    /** 父权限id */
    @ApiModelProperty(value = "父权限id")
    @TableField("parent_id")
    open var parentId: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    open var updateTime: LocalDateTime? = null

    /** 是否禁用 0否 1是 */
    @ApiModelProperty(value = "是否禁用 0否 1是")
    @TableField("is_disable")
    open var isDisable: Boolean? = null

    /** 是否匿名访问 0否 1是 */
    @ApiModelProperty(value = "是否匿名访问 0否 1是")
    @TableField("is_anonymous")
    open var isAnonymous: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val RESOURCE_NAME : String = "resource_name"

        const val URL : String = "url"

        const val REQUEST_METHOD : String = "request_method"

        const val PARENT_ID : String = "parent_id"

        const val CREATE_TIME : String = "create_time"

        const val UPDATE_TIME : String = "update_time"

        const val IS_DISABLE : String = "is_disable"

        const val IS_ANONYMOUS : String = "is_anonymous"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ResourceEntity{" +
        "id=" + id +
        ", resourceName=" + resourceName +
        ", url=" + url +
        ", requestMethod=" + requestMethod +
        ", parentId=" + parentId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDisable=" + isDisable +
        ", isAnonymous=" + isAnonymous +
        "}"
    }

}
