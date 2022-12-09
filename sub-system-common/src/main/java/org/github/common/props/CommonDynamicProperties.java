package org.github.common.props;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.props.DynamicProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties("dynamic")
@RefreshScope
@Component
@Data
public class CommonDynamicProperties extends DynamicProperties {
}
