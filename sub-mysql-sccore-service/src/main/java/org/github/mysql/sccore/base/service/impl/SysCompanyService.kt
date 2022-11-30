@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysCompanyEntity;
import org.github.mysql.sccore.base.mapper.ISysCompanyMapper;
import org.github.mysql.sccore.base.service.ISysCompanyService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 企业信息管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysCompanyService : ServiceImpl<ISysCompanyMapper, SysCompanyEntity>(), ISysCompanyService
