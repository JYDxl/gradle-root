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
@TableName("tb_operation_log")
@ApiModel(value = "OperationLogEntity对象", description = "")
open class OperationLogEntity : Entity() {

    /** 主键id */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    open var id: Int? = null

    /** 操作模块 */
    @ApiModelProperty(value = "操作模块")
    @TableField("opt_module")
    open var optModule: String? = null

    /** 操作类型 */
    @ApiModelProperty(value = "操作类型")
    @TableField("opt_type")
    open var optType: String? = null

    /** 操作url */
    @ApiModelProperty(value = "操作url")
    @TableField("opt_url")
    open var optUrl: String? = null

    /** 操作方法 */
    @ApiModelProperty(value = "操作方法")
    @TableField("opt_method")
    open var optMethod: String? = null

    /** 操作描述 */
    @ApiModelProperty(value = "操作描述")
    @TableField("opt_desc")
    open var optDesc: String? = null

    /** 请求参数 */
    @ApiModelProperty(value = "请求参数")
    @TableField("request_param")
    open var requestParam: String? = null

    /** 请求方式 */
    @ApiModelProperty(value = "请求方式")
    @TableField("request_method")
    open var requestMethod: String? = null

    /** 返回数据 */
    @ApiModelProperty(value = "返回数据")
    @TableField("response_data")
    open var responseData: String? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Int? = null

    /** 用户昵称 */
    @ApiModelProperty(value = "用户昵称")
    open var nickname: String? = null

    /** 操作ip */
    @ApiModelProperty(value = "操作ip")
    @TableField("ip_addr")
    open var ipAddr: String? = null

    /** 操作地址 */
    @ApiModelProperty(value = "操作地址")
    @TableField("ip_source")
    open var ipSource: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val OPT_MODULE : String = "opt_module"

        const val OPT_TYPE : String = "opt_type"

        const val OPT_URL : String = "opt_url"

        const val OPT_METHOD : String = "opt_method"

        const val OPT_DESC : String = "opt_desc"

        const val REQUEST_PARAM : String = "request_param"

        const val REQUEST_METHOD : String = "request_method"

        const val RESPONSE_DATA : String = "response_data"

        const val USER_ID : String = "user_id"

        const val NICKNAME : String = "nickname"

        const val IP_ADDR : String = "ip_addr"

        const val IP_SOURCE : String = "ip_source"

        const val CREATE_TIME : String = "create_time"

    }

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "OperationLogEntity{" +
        "id=" + id +
        ", optModule=" + optModule +
        ", optType=" + optType +
        ", optUrl=" + optUrl +
        ", optMethod=" + optMethod +
        ", optDesc=" + optDesc +
        ", requestParam=" + requestParam +
        ", requestMethod=" + requestMethod +
        ", responseData=" + responseData +
        ", userId=" + userId +
        ", nickname=" + nickname +
        ", ipAddr=" + ipAddr +
        ", ipSource=" + ipSource +
        ", createTime=" + createTime +
        "}"
    }

}
