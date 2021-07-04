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
@TableName("tb_unique_view")
@ApiModel(value = "UniqueViewEntity对象", description = "")
open class UniqueViewEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 时间 */
    @ApiModelProperty(value = "时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    /** 访问量 */
    @ApiModelProperty(value = "访问量")
    @TableField("views_count")
    open var viewsCount: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val CREATE_TIME : String = "create_time"

        const val VIEWS_COUNT : String = "views_count"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "UniqueViewEntity{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", viewsCount=" + viewsCount +
        "}"
    }

}
