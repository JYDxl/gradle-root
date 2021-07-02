package org.github.mysql.leadnews.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 敏感词信息表
 *
 * @author JYD_XL
 */
@TableName("ad_sensitive")
@ApiModel(value = "AdSensitiveEntity对象", description = "敏感词信息表")
open class AdSensitiveEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 敏感词 */
    @ApiModelProperty(value = "敏感词")
    open var sensitives: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val SENSITIVES : String = "sensitives"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "AdSensitiveEntity{" +
        "id=" + id +
        ", sensitives=" + sensitives +
        ", createdTime=" + createdTime +
        "}"
    }

}
