package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import org.github.base.AbstractEntity
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("sys_dept")
class SysDeptEntity: AbstractEntity() {

    /** 部门id */
    @TableId(value = "dept_id", type = IdType.AUTO)
    var deptId: Long? = null

    /** 父部门id */
    var parentId: Long? = null

    /** 祖级列表 */
    var ancestors: String? = null

    /** 部门名称 */
    var deptName: String? = null

    /** 显示顺序 */
    var orderNum: Int? = null

    /** 负责人 */
    var leader: String? = null

    /** 联系电话 */
    var phone: String? = null

    /** 邮箱 */
    var email: String? = null

    /** 部门状态（0正常 1停用） */
    var status: String? = null

    /** 删除标志（0代表存在 2代表删除） */
    var delFlag: String? = null

    /** 创建者 */
    var createBy: String? = null

    /** 创建时间 */
    var createTime: LocalDateTime? = null

    /** 更新者 */
    var updateBy: String? = null

    /** 更新时间 */
    var updateTime: LocalDateTime? = null

}
