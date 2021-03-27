package org.github.base.service.impl;

import org.github.base.entity.StuEntity;
import org.github.base.mapper.IStuMapper;
import org.github.base.service.IStuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class StuServiceImpl extends ServiceImpl<IStuMapper, StuEntity> implements IStuService {}
