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
@TableName("tb_category")
@ApiModel(value = "CategoryEntity对象", description = "")
open class CategoryEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 分类名 */
    @ApiModelProperty(value = "分类名")
    @TableField("category_name")
    open var categoryName: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CATEGORY_NAME : String = "category_name"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "CategoryEntity{" +
        "id=" + id +
        ", categoryName=" + categoryName +
        ", createTime=" + createTime +
        "}"
    }

}
