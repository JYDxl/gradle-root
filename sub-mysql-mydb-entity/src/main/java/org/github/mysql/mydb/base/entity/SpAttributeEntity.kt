@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 属性表
 *
 * @author JYD_XL
 */
@TableName("sp_attribute")
@ApiModel(value = "SpAttributeEntity对象", description = "属性表")
open class SpAttributeEntity : Entity() {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Long? = null

    /** 属性名称 */
    @ApiModelProperty(value = "属性名称")
    @TableField("attr_name")
    open var attrName: String? = null

    /** 外键，类型id */
    @ApiModelProperty(value = "外键，类型id")
    @TableField("cat_id")
    open var catId: Int? = null

    /** only:输入框(唯一)  many:后台下拉列表/前台单选框 */
    @ApiModelProperty(value = "only:输入框(唯一)  many:后台下拉列表/前台单选框")
    @TableField("attr_sel")
    open var attrSel: String? = null

    /** manual:手工录入  list:从列表选择 */
    @ApiModelProperty(value = "manual:手工录入  list:从列表选择")
    @TableField("attr_write")
    open var attrWrite: String? = null

    /** 可选值列表信息,例如颜色：白色,红色,绿色,多个可选值通过逗号分隔 */
    @ApiModelProperty(value = "可选值列表信息,例如颜色：白色,红色,绿色,多个可选值通过逗号分隔")
    @TableField("attr_vals")
    open var attrVals: String? = null

    /** 删除时间标志 */
    @ApiModelProperty(value = "删除时间标志")
    @TableField("delete_time")
    open var deleteTime: Int? = null

    override fun toString(): String {
        return "SpAttributeEntity{" +
        "id=" + id +
        ", attrName=" + attrName +
        ", catId=" + catId +
        ", attrSel=" + attrSel +
        ", attrWrite=" + attrWrite +
        ", attrVals=" + attrVals +
        ", deleteTime=" + deleteTime +
        "}"
    }

}
