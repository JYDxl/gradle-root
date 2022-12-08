@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.FileMbpPo;
import org.github.mysql.center.mapper.IFileMbpMapper;
import org.github.mysql.center.service.IFileMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文件 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class FileMbpService : ServiceImpl<IFileMbpMapper, FileMbpPo>(), IFileMbpService
