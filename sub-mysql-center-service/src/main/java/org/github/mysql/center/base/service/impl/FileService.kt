@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.FileEntity;
import org.github.mysql.center.base.mapper.IFileMapper;
import org.github.mysql.center.base.service.IFileService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文件 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class FileService : ServiceImpl<IFileMapper, FileEntity>(), IFileService
