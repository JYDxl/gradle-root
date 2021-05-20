package org.github.base.mapper;

import org.github.base.entity.MemberEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@MyBatisMapper
public interface IMemberMapper extends IMapper<MemberEntity> {}
