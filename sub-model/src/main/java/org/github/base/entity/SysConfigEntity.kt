package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_config")
class SysConfigEntity: AbstractEntity() {

    /** 参数主键 */
    @TableId(value = "config_id", type = IdType.AUTO)
    var configId: Int? = null

    /** 参数名称 */
    var configName: String? = null

    /** 参数键名 */
    var configKey: String? = null

    /** 参数键值 */
    var configValue: String? = null

    /** 系统内置（Y是 N否） */
    var configType: String? = null

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
