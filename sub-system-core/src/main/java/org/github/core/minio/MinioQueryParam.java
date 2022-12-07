package org.github.core.minio;

import lombok.Data;

@Data
public class MinioQueryParam {
    private String bucket;
    private String path;
    private String name;

    public String getFullName() {
        return path + name;
    }
}
