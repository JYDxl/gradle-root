package org.github.core.minio;

import lombok.Data;

import static cn.hutool.core.date.DatePattern.PURE_DATETIME_MS_PATTERN;
import static cn.hutool.core.date.LocalDateTimeUtil.format;
import static java.time.LocalDate.now;

@Data
public class MinioQueryBo {
    private String bucket;
    private String name;
    private String path = format(now(), PURE_DATETIME_MS_PATTERN);

    public String getFullName() {
        return path + name;
    }
}
