package org.github.mysql.seata.account.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 账户表
 *
 * @author JYD_XL
 */
@TableName("t_account")
@ApiModel(value = "TAccountEntity对象", description = "账户表")
open class TAccountEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "account_id", type = IdType.ASSIGN_ID)
    open var accountId: Long? = null

    /** 用户id */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    open var userId: Long? = null

    /** 总额度 */
    @ApiModelProperty(value = "总额度")
    open var total: BigDecimal? = null

    /** 已用额度 */
    @ApiModelProperty(value = "已用额度")
    open var used: BigDecimal? = null

    /** 剩余可用额度 */
    @ApiModelProperty(value = "剩余可用额度")
    open var residue: BigDecimal? = null

    companion object {

        private const val serialVersionUID = 1L

        const val ACCOUNT_ID : String = "account_id"

        const val USER_ID : String = "user_id"

        const val TOTAL : String = "total"

        const val USED : String = "used"

        const val RESIDUE : String = "residue"

    }

    override fun pkVal(): java.io.Serializable? {
        return accountId
    }

    override fun toString(): String {
        return "TAccountEntity{" +
        "accountId=" + accountId +
        ", userId=" + userId +
        ", total=" + total +
        ", used=" + used +
        ", residue=" + residue +
        "}"
    }

}
