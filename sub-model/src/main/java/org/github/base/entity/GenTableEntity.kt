package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 代码生成业务表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("gen_table")
class GenTableEntity: AbstractEntity() {

    /** 编号 */
    @TableId(value = "table_id", type = IdType.AUTO)
    var tableId: Long? = null

    /** 表名称 */
    var tableName: String? = null

    /** 表描述 */
    var tableComment: String? = null

    /** 实体类名称 */
    var className: String? = null

    /** 使用的模板（crud单表操作 tree树表操作） */
    var tplCategory: String? = null

    /** 生成包路径 */
    var packageName: String? = null

    /** 生成模块名 */
    var moduleName: String? = null

    /** 生成业务名 */
    var businessName: String? = null

    /** 生成功能名 */
    var functionName: String? = null

    /** 生成功能作者 */
    var functionAuthor: String? = null

    /** 其它生成选项 */
    var options: String? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

    /** 备注 */
    var remark: String? = null

}
