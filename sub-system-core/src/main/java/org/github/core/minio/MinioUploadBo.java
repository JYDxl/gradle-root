package org.github.core.minio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.InputStream;

@EqualsAndHashCode(callSuper = true)
@Data
public class MinioUploadBo extends MinioQueryBo {
    private InputStream input;

    private long objSize = -1;
}
