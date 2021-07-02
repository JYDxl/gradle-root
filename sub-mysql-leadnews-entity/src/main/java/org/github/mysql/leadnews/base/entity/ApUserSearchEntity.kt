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
 * APP用户搜索信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_search")
@ApiModel(value = "ApUserSearchEntity对象", description = "APP用户搜索信息表")
open class ApUserSearchEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    @TableField("entry_id")
    open var entryId: Int? = null

    /** 搜索词 */
    @ApiModelProperty(value = "搜索词")
    open var keyword: String? = null

    /** 当前状态0 无效 1有效 */
    @ApiModelProperty(value = "当前状态0 无效 1有效")
    open var status: Int? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val ENTRY_ID : String = "entry_id"

        const val KEYWORD : String = "keyword"

        const val STATUS : String = "status"

        const val CREATED_TIME : String = "created_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserSearchEntity{" +
        "id=" + id +
        ", entryId=" + entryId +
        ", keyword=" + keyword +
        ", status=" + status +
        ", createdTime=" + createdTime +
        "}"
    }

}
