package org.github.props;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("xxl")
@Component
public class XxlJobProperties extends XxlJobExecutor {
}
