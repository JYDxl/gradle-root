package org.github.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.github.props.XxlJobProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static cn.hutool.core.bean.BeanUtil.copyProperties;

@Configuration
public class XxlJobConfig {
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProperties xxlJobProperties) {
        return copyProperties(xxlJobProperties, XxlJobSpringExecutor.class);
    }
}
