@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.account.base.service.impl;

import org.github.mysql.seata.account.base.entity.TAccountEntity;
import org.github.mysql.seata.account.base.mapper.ITAccountMapper;
import org.github.mysql.seata.account.base.service.ITAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 账户表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TAccountServiceImpl : ServiceImpl<ITAccountMapper, TAccountEntity>(), ITAccountService
