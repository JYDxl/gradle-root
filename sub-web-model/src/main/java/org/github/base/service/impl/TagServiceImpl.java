package org.github.base.service.impl;

import org.github.base.entity.TagEntity;
import org.github.base.mapper.ITagMapper;
import org.github.base.service.ITagService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class TagServiceImpl extends ServiceImpl<ITagMapper, TagEntity> implements ITagService {}
