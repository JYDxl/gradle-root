package org.github.props;

import java.util.List;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import static com.google.common.collect.Lists.*;

@ConfigurationProperties("custom.dynamic")
@RefreshScope
@Component
@Data
public class DynamicProperties {
  private List<String> whiteList = newArrayList();
}
