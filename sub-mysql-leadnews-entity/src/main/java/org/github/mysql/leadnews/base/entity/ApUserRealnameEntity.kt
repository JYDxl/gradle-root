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
 * APP实名认证信息表
 *
 * @author JYD_XL
 */
@TableName("ap_user_realname")
@ApiModel(value = "ApUserRealnameEntity对象", description = "APP实名认证信息表")
open class ApUserRealnameEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    /** 账号ID */
    @ApiModelProperty(value = "账号ID")
    @TableField("user_id")
    open var userId: Int? = null

    open var name: String? = null

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称")
    open var idno: String? = null

    /** 正面照片 */
    @ApiModelProperty(value = "正面照片")
    @TableField("font_image")
    open var fontImage: String? = null

    /** 背面照片 */
    @ApiModelProperty(value = "背面照片")
    @TableField("back_image")
    open var backImage: String? = null

    /** 手持照片 */
    @ApiModelProperty(value = "手持照片")
    @TableField("hold_image")
    open var holdImage: String? = null

    /** 活体照片 */
    @ApiModelProperty(value = "活体照片")
    @TableField("live_image")
    open var liveImage: String? = null

    /** 状态	            0 创建中	            1 待审核	            2 审核失败	            9 审核通过 */
    @ApiModelProperty(value = "状态	            0 创建中	            1 待审核	            2 审核失败	            9 审核通过")
    open var status: Int? = null

    /** 拒绝原因 */
    @ApiModelProperty(value = "拒绝原因")
    open var reason: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    open var createdTime: LocalDateTime? = null

    /** 提交时间 */
    @ApiModelProperty(value = "提交时间")
    @TableField("submited_time")
    open var submitedTime: LocalDateTime? = null

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    open var updatedTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USER_ID : String = "user_id"

        const val NAME : String = "name"

        const val IDNO : String = "idno"

        const val FONT_IMAGE : String = "font_image"

        const val BACK_IMAGE : String = "back_image"

        const val HOLD_IMAGE : String = "hold_image"

        const val LIVE_IMAGE : String = "live_image"

        const val STATUS : String = "status"

        const val REASON : String = "reason"

        const val CREATED_TIME : String = "created_time"

        const val SUBMITED_TIME : String = "submited_time"

        const val UPDATED_TIME : String = "updated_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "ApUserRealnameEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", idno=" + idno +
        ", fontImage=" + fontImage +
        ", backImage=" + backImage +
        ", holdImage=" + holdImage +
        ", liveImage=" + liveImage +
        ", status=" + status +
        ", reason=" + reason +
        ", createdTime=" + createdTime +
        ", submitedTime=" + submitedTime +
        ", updatedTime=" + updatedTime +
        "}"
    }

}
