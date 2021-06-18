@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service;

import org.github.mysql.mydb.base.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户-角色关系表 服务类
 *
 * @author JYD_XL
 */
interface ISysUserRoleService : IService<SysUserRoleEntity>