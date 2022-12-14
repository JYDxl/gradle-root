package org.github.center.controller

import cn.dev33.satoken.stp.StpUtil.getPermissionList
import cn.dev33.satoken.stp.StpUtil.getRoleList
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.annotation.Resource
import org.github.center.service.ICenterService
import org.github.core.spring.restful.json.JSONArrayReturn
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("授权功能")
@RequestMapping("/auth/")
@RestController
class AuthController {
    @Resource
    private lateinit var centerService: ICenterService

    @ApiOperation("授权功能-刷新token")
    @PostMapping("fresh")
    fun refresh() = centerService.refresh()

    @ApiOperation("授权功能-权限列表")
    @PostMapping("permissionList")
    fun permissionList(): JSONArrayReturn<String> = JSONArrayReturn.of(getPermissionList())

    @ApiOperation("授权功能-角色列表")
    @PostMapping("roleList")
    fun roleList(): JSONArrayReturn<String> = JSONArrayReturn.of(getRoleList())

    @ApiOperation("授权功能-菜单列表")
    @PostMapping("menuList")
    fun menuList(): JSONArrayReturn<String> = centerService.menuList()
}
