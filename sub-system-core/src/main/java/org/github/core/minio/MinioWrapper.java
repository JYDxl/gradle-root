package org.github.core.minio;

import io.minio.BucketExistsArgs;
import io.minio.CopyObjectArgs;
import io.minio.CopySource;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveBucketArgs;
import io.minio.RemoveObjectArgs;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.core.exception.ServerException;
import static cn.hutool.core.io.unit.DataSizeUtil.parse;
import static io.minio.http.Method.GET;

@AllArgsConstructor
@Slf4j
public class MinioWrapper {
  private final MinioClient minio;

  public void copy(MinioQueryBo source, MinioQueryBo target) {
    createBucket(target);
    val from = CopySource.builder().bucket(source.getBucket()).object(source.getFullName()).build();
    val args = CopyObjectArgs.builder().source(from).bucket(target.getBucket()).object(target.getFullName()).build();
    try {
      minio.copyObject(args);
    } catch (Exception e) {
      throw new ServerException("复制数据失败", e);
    }
  }

  public void createBucket(MinioQueryBo bo) {
    boolean exists;
    try {
      exists = minio.bucketExists(BucketExistsArgs.builder().bucket(bo.getBucket()).build());
    } catch (Exception e) {
      throw new ServerException("获取数据失败", e);
    }
    if (exists) return;
    try {
      minio.makeBucket(MakeBucketArgs.builder().bucket(bo.getBucket()).build());
    } catch (Exception e) {
      throw new ServerException("创建仓库失败", e);
    }
  }

  public InputStream download(MinioQueryBo bo) {
    val args = GetObjectArgs.builder().bucket(bo.getBucket()).object(bo.getFullName()).build();
    try {
      return minio.getObject(args);
    } catch (Exception e) {
      throw new ServerException("下载数据失败", e);
    }
  }

  public String getUrl(MinioQueryBo bo) {
    val args = GetPresignedObjectUrlArgs.builder().method(GET).bucket(bo.getBucket()).object(bo.getFullName()).build();
    try {
      return minio.getPresignedObjectUrl(args);
    } catch (Exception e) {
      throw new ServerException("获取地址失败");
    }
  }

  public void remove(MinioQueryBo bo) {
    val args = RemoveObjectArgs.builder().bucket(bo.getBucket()).object(bo.getFullName()).build();
    try {
      minio.removeObject(args);
    } catch (Exception e) {
      throw new ServerException("删除数据失败", e);
    }
  }

  public void removeBucket(MinioQueryBo bo) {
    try {
      minio.removeBucket(RemoveBucketArgs.builder().bucket(bo.getBucket()).build());
    } catch (Exception e) {
      throw new ServerException("删除仓库失败", e);
    }
  }

  public void upload(MinioUploadBo bo) {
    createBucket(bo);
    val objSize = bo.getObjSize();
    val size    = objSize == -1 ? new Size(-1, parse("8MB")) : new Size(objSize, -1);
    val args    = PutObjectArgs.builder().bucket(bo.getBucket()).object(bo.getFullName()).stream(bo.getInput(), size.getItemSize(), size.getPartSize()).build();
    try {
      minio.putObject(args);
    } catch (Exception e) {
      throw new ServerException("上传数据失败", e);
    }
  }

  @Data
  private static class Size {
    private final long itemSize;

    private final long partSize;
  }
}
