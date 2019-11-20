package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_dict_data")
class SysDictDataEntity: AbstractEntity() {

    /** 字典编码 */
    @TableId(value = "dict_code", type = IdType.AUTO)
    var dictCode: Long? = null

    /** 字典排序 */
    var dictSort: Int? = null

    /** 字典标签 */
    var dictLabel: String? = null

    /** 字典键值 */
    var dictValue: String? = null

    /** 字典类型 */
    var dictType: String? = null

    /** 样式属性（其他样式扩展） */
    var cssClass: String? = null

    /** 表格回显样式 */
    var listClass: String? = null

    /** 是否默认（Y是 N否） */
    var isDefault: String? = null

    /** 状态（0正常 1停用） */
    var status: String? = null

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
