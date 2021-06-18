package org.github.mysql.mydb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 安全问题类别表
 *
 * @author JYD_XL
 */
@TableName("tab_safe_question_type")
@ApiModel(value = "TabSafeQuestionTypeEntity对象", description = "安全问题类别表")
open class TabSafeQuestionTypeEntity : Entity() {

    /** 主键id */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: String? = null

    /** 项目id */
    @ApiModelProperty(value = "项目id")
    @TableField("project_id")
    open var projectId: String? = null

    /** 父级类型id */
    @ApiModelProperty(value = "父级类型id")
    @TableField("parent_id")
    open var parentId: String? = null

    /** 父级类型名称 */
    @ApiModelProperty(value = "父级类型名称")
    @TableField("parent_name")
    open var parentName: String? = null

    /** 问题类型编码 */
    @ApiModelProperty(value = "问题类型编码")
    @TableField("type_code")
    open var typeCode: String? = null

    /** 问题类型名称 */
    @ApiModelProperty(value = "问题类型名称")
    @TableField("type_name")
    open var typeName: String? = null

    /** 备注 */
    @ApiModelProperty(value = "备注")
    open var remark: String? = null

    /** 排序 */
    @ApiModelProperty(value = "排序")
    open var sort: Int? = null

    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    open var creater: String? = null

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    open var createTime: LocalDateTime? = null

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "TabSafeQuestionTypeEntity{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", parentId=" + parentId +
        ", parentName=" + parentName +
        ", typeCode=" + typeCode +
        ", typeName=" + typeName +
        ", remark=" + remark +
        ", sort=" + sort +
        ", creater=" + creater +
        ", createTime=" + createTime +
        "}"
    }

}