package org.github.core.props;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import static com.google.common.collect.Lists.newArrayList;

@ConfigurationProperties("dynamic")
@RefreshScope
@Component
@Data
public class DynamicProperties {
    private List<String> whiteList = newArrayList();
}
