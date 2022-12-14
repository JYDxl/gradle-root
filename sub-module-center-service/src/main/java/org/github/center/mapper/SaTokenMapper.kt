package org.github.center.mapper

import org.github.core.mybatis.MyBatisMapper

@MyBatisMapper
interface SaTokenMapper {
    fun getRoleList(loginId: Any): List<String>
    fun getPermissionList(roleId: Any): List<String>
    fun getMenuList(roleList: List<String>): List<String>
}
