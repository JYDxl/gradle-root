package org.github.base

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl

open class ServiceImpl<M: IMapper<T>, T>: ServiceImpl<M, T>()
