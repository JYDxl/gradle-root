@file:Suppress("RedundantSemicolon")

package org.github.postgresql.runoobdb.base.service.impl;

import org.github.postgresql.runoobdb.base.entity.CompanyEntity;
import org.github.postgresql.runoobdb.base.mapper.ICompanyMapper;
import org.github.postgresql.runoobdb.base.service.ICompanyService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CompanyServiceImpl : ServiceImpl<ICompanyMapper, CompanyEntity>(), ICompanyService
