package org.github.common.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.github.core.props.XxlJobProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlJobConfig {
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProperties props) {
        XxlJobSpringExecutor executor = new XxlJobSpringExecutor();
        executor.setAdminAddresses(props.getAdminAddresses());
        executor.setAccessToken(props.getAccessToken());
        executor.setAppname(props.getAppname());
        executor.setAddress(props.getAddress());
        executor.setIp(props.getIp());
        executor.setPort(props.getPort());
        executor.setLogPath(props.getLogPath());
        executor.setLogRetentionDays(props.getLogRetentionDays());
        return executor;
    }
}
