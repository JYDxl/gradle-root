package org.github.core.minio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.InputStream;

@EqualsAndHashCode(callSuper = true)
@Data
public class MinioUploadParam extends MinioQueryParam {
    private InputStream input;

    private long objSize = -1;
}
