package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 代码生成业务表字段
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("gen_table_column")
class GenTableColumnEntity: AbstractEntity() {

    /** 编号 */
    @TableId(value = "column_id", type = IdType.AUTO)
    var columnId: Long? = null

    /** 归属表编号 */
    var tableId: String? = null

    /** 列名称 */
    var columnName: String? = null

    /** 列描述 */
    var columnComment: String? = null

    /** 列类型 */
    var columnType: String? = null

    /** JAVA类型 */
    var javaType: String? = null

    /** JAVA字段名 */
    var javaField: String? = null

    /** 是否主键（1是） */
    var isPk: String? = null

    /** 是否自增（1是） */
    var isIncrement: String? = null

    /** 是否必填（1是） */
    var isRequired: String? = null

    /** 是否为插入字段（1是） */
    var isInsert: String? = null

    /** 是否编辑字段（1是） */
    var isEdit: String? = null

    /** 是否列表字段（1是） */
    var isList: String? = null

    /** 是否查询字段（1是） */
    var isQuery: String? = null

    /** 查询方式（等于、不等于、大于、小于、范围） */
    var queryType: String? = null

    /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
    var htmlType: String? = null

    /** 字典类型 */
    var dictType: String? = null

    /** 排序 */
    var sort: Int? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

}
