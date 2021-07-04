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
@TableName("tb_tag")
@ApiModel(value = "TagEntity对象", description = "")
open class TagEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 标签名 */
    @ApiModelProperty(value = "标签名")
    @TableField("tag_name")
    open var tagName: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val TAG_NAME : String = "tag_name"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "TagEntity{" +
        "id=" + id +
        ", tagName=" + tagName +
        ", createTime=" + createTime +
        "}"
    }

}
