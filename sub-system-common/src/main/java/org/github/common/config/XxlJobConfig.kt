package org.github.common.config

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor
import org.github.core.props.XxlJobProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class XxlJobConfig {
    @Bean
    fun xxlJobExecutor(props: XxlJobProperties) = XxlJobSpringExecutor().apply {
        setAdminAddresses(props.adminAddresses)
        setAccessToken(props.accessToken)
        setAppname(props.appname)
        setAddress(props.address)
        setIp(props.ip)
        setPort(props.port)
        setLogPath(props.logPath)
        setLogRetentionDays(props.logRetentionDays)
    }
}
