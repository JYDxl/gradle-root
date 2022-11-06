@file:Suppress("UnusedImport", "unused")

package org.github.mysql.sccore.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 数据字典表
 *
 * @author JYD_XL
 */
@TableName("t_sys_code")
@ApiModel(value = "SysCodeEntity对象", description = "数据字典表")
open class SysCodeEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 启用标志，1：可用，2：不可用 */
    @ApiModelProperty(value = "启用标志，1：可用，2：不可用")
    @TableField("use_flag")
    open var useFlag: String? = null

    /** 码值类型ID */
    @ApiModelProperty(value = "码值类型ID")
    @TableField("code_type_id")
    open var codeTypeId: String? = null

    /** 码值 */
    @ApiModelProperty(value = "码值")
    @TableField("code_value")
    open var codeValue: String? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    @TableField("user_create")
    open var userCreate: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_datetime")
    open var createDatetime: LocalDateTime? = null

    /** 修改人 */
    @ApiModelProperty(value = "修改人")
    @TableField("user_modify")
    open var userModify: String? = null

    /** 修改时间 */
    @ApiModelProperty(value = "修改时间")
    @TableField("modify_datetime")
    open var modifyDatetime: LocalDateTime? = null

    /** 顺序 */
    @ApiModelProperty(value = "顺序")
    @TableField("code_order")
    open var codeOrder: Int? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ID : String = "id"

        const val USE_FLAG : String = "use_flag"

        const val CODE_TYPE_ID : String = "code_type_id"

        const val CODE_VALUE : String = "code_value"

        const val USER_CREATE : String = "user_create"

        const val CREATE_DATETIME : String = "create_datetime"

        const val USER_MODIFY : String = "user_modify"

        const val MODIFY_DATETIME : String = "modify_datetime"

        const val CODE_ORDER : String = "code_order"

    }

    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysCodeEntity{" +
        "id=" + id +
        ", useFlag=" + useFlag +
        ", codeTypeId=" + codeTypeId +
        ", codeValue=" + codeValue +
        ", userCreate=" + userCreate +
        ", createDatetime=" + createDatetime +
        ", userModify=" + userModify +
        ", modifyDatetime=" + modifyDatetime +
        ", codeOrder=" + codeOrder +
        "}"
    }

}
