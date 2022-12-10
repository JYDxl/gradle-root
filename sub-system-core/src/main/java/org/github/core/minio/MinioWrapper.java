package org.github.core.minio;

import io.minio.CopyObjectArgs;
import io.minio.CopySource;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.github.core.exception.ServerException;
import static cn.hutool.core.io.unit.DataSizeUtil.parse;
import static io.minio.http.Method.GET;

@AllArgsConstructor
@Slf4j
public class MinioWrapper {
  private final MinioClient minioClient;

  public String copy(MinioQueryBo source, MinioQueryBo target) {
    CopySource     from = CopySource.builder().bucket(source.getBucket()).object(source.getFullName()).build();
    CopyObjectArgs args = CopyObjectArgs.builder().source(from).bucket(target.getBucket()).object(target.getFullName()).build();
    try {
      ObjectWriteResponse writeResponse = minioClient.copyObject(args);
      return writeResponse.etag();
    } catch (Exception e) {
      throw new ServerException("在minio复制数据失败：" + e.getMessage());
    }
  }

  public InputStream download(MinioQueryBo param) {
    GetObjectArgs args = GetObjectArgs.builder().bucket(param.getBucket()).object(param.getFullName()).build();
    try {
      return minioClient.getObject(args);
    } catch (Exception e) {
      throw new ServerException("从minio获取数据失败：" + e.getMessage());
    }
  }

  public String getUrl(MinioQueryBo param) {
    GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder().method(GET).bucket(param.getBucket()).object(param.getFullName()).build();
    try {
      return minioClient.getPresignedObjectUrl(args);
    } catch (Exception e) {
      throw new ServerException("从minio获取下载地址失败：" + e.getMessage());
    }
  }

  public void remove(MinioQueryBo param) {
    RemoveObjectArgs args = RemoveObjectArgs.builder().bucket(param.getBucket()).object(param.getFullName()).build();
    try {
      minioClient.removeObject(args);
    } catch (Exception e) {
      throw new ServerException("在minio删除数据失败：" + e.getMessage());
    }
  }

  public void upload(MinioUploadBo param) {
    long          objSize = param.getObjSize();
    Size          size    = objSize == -1 ? new Size(-1, parse("8MB")) : new Size(objSize, -1);
    PutObjectArgs args    = PutObjectArgs.builder().bucket(param.getBucket()).object(param.getFullName()).stream(param.getInput(), size.getItemSize(), size.getPartSize()).build();
    try {
      minioClient.putObject(args);
    } catch (Exception e) {
      throw new ServerException("向minio上传数据失败：" + e.getMessage());
    }
  }

  @Data
  private static class Size {
    private final long itemSize;

    private final long partSize;
  }
}
