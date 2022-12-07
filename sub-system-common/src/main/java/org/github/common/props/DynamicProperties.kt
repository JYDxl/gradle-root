package org.github.common.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Component

@ConfigurationProperties("dynamic")
@RefreshScope
@Component
class DynamicProperties
