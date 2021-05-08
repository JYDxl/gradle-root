package org.github.base.mapper;

import org.github.base.entity.TagEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@MyBatisMapper
public interface ITagMapper extends IMapper<TagEntity> {}
