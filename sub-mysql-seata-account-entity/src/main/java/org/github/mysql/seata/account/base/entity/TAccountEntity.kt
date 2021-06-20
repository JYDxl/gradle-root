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
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

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

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "TAccountEntity{" +
        "id=" + id +
        ", userId=" + userId +
        ", total=" + total +
        ", used=" + used +
        ", residue=" + residue +
        "}"
    }

}
