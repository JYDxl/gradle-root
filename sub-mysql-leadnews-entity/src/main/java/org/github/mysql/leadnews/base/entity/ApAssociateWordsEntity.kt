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
 * 联想词表
 *
 * @author JYD_XL
 */
@TableName("ap_associate_words")
@ApiModel(value = "ApAssociateWordsEntity对象", description = "联想词表")
open class ApAssociateWordsEntity : Entity() {

    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 联想词 */
    @ApiModelProperty(value = "联想词")
    @TableField("associate_words")
    open var associateWords: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ASSOCIATE_WORDS : String = "associate_words"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApAssociateWordsEntity{" +
        "id=" + id +
        ", associateWords=" + associateWords +
        ", createdTime=" + createdTime +
        "}"
    }

}
