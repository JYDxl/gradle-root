package org.github.base.service.impl;

import org.github.base.entity.MemberFavEntity;
import org.github.base.mapper.IMemberFavMapper;
import org.github.base.service.IMemberFavService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class MemberFavServiceImpl extends ServiceImpl<IMemberFavMapper, MemberFavEntity> implements IMemberFavService {}
