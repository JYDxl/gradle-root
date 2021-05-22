package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysMenuEntity;
import org.github.mysql.web.base.mapper.ISysMenuMapper;
import org.github.mysql.web.base.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<ISysMenuMapper, SysMenuEntity> implements ISysMenuService {}
