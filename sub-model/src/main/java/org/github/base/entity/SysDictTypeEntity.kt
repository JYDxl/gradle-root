package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_dict_type")
class SysDictTypeEntity: AbstractEntity() {

    /** 字典主键 */
    @TableId(value = "dict_id", type = IdType.AUTO)
    var dictId: Long? = null

    /** 字典名称 */
    var dictName: String? = null

    /** 字典类型 */
    var dictType: String? = null

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
