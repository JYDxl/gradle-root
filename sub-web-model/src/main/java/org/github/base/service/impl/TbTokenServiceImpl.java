package org.github.base.service.impl;

import org.github.base.entity.TbTokenEntity;
import org.github.base.mapper.ITbTokenMapper;
import org.github.base.service.ITbTokenService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户Token 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class TbTokenServiceImpl extends ServiceImpl<ITbTokenMapper, TbTokenEntity> implements ITbTokenService {}
