@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.FileMbpEntity;
import org.github.mysql.center.base.mapper.IFileMbpMapper;
import org.github.mysql.center.base.service.IFileMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文件 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class FileMbpService : ServiceImpl<IFileMbpMapper, FileMbpEntity>(), IFileMbpService
