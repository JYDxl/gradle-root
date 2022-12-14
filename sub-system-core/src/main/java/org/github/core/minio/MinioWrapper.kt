package org.github.core.minio

import cn.hutool.core.io.unit.DataSizeUtil.parse
import io.minio.BucketExistsArgs
import io.minio.CopyObjectArgs
import io.minio.CopySource
import io.minio.GetObjectArgs
import io.minio.GetPresignedObjectUrlArgs
import io.minio.MakeBucketArgs
import io.minio.MinioClient
import io.minio.PutObjectArgs
import io.minio.RemoveBucketArgs
import io.minio.RemoveObjectArgs
import io.minio.http.Method
import java.io.InputStream
import lombok.AllArgsConstructor
import lombok.Data
import lombok.extern.slf4j.Slf4j
import org.github.core.exception.ServerException

@AllArgsConstructor
@Slf4j
class MinioWrapper(private val minio: MinioClient) {
    fun copy(source: MinioQueryBo, target: MinioQueryBo) {
        createBucket(target)
        val from = CopySource.builder().bucket(source.bucket).`object`(source.fullName).build()!!
        val args = CopyObjectArgs.builder().source(from).bucket(target.bucket).`object`(target.fullName).build()!!
        try {
            minio.copyObject(args)
        } catch (e: Exception) {
            throw ServerException("复制数据失败", e)
        }
    }

    fun createBucket(bo: MinioQueryBo) {
        val exists: Boolean = try {
            minio.bucketExists(BucketExistsArgs.builder().bucket(bo.bucket).build())
        } catch (e: Exception) {
            throw ServerException("获取数据失败", e)
        }
        if (exists) return
        try {
            minio.makeBucket(MakeBucketArgs.builder().bucket(bo.bucket).build())
        } catch (e: Exception) {
            throw ServerException("创建仓库失败", e)
        }
    }

    fun download(bo: MinioQueryBo): InputStream {
        val args = GetObjectArgs.builder().bucket(bo.bucket).`object`(bo.fullName).build()
        return try {
            minio.getObject(args)
        } catch (e: Exception) {
            throw ServerException("下载数据失败", e)
        }
    }

    fun getUrl(bo: MinioQueryBo): String {
        val args = GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bo.bucket).`object`(bo.fullName).build()
        return try {
            minio.getPresignedObjectUrl(args)
        } catch (e: Exception) {
            throw ServerException("获取地址失败")
        }
    }

    fun remove(bo: MinioQueryBo) {
        val args = RemoveObjectArgs.builder().bucket(bo.bucket).`object`(bo.fullName).build()
        try {
            minio.removeObject(args)
        } catch (e: Exception) {
            throw ServerException("删除数据失败", e)
        }
    }

    fun removeBucket(bo: MinioQueryBo) {
        try {
            minio.removeBucket(RemoveBucketArgs.builder().bucket(bo.bucket).build())
        } catch (e: Exception) {
            throw ServerException("删除仓库失败", e)
        }
    }

    fun upload(bo: MinioUploadBo) {
        createBucket(bo)
        val objSize = bo.objSize
        val size = if (objSize == -1L) Size(-1L, parse("8MB")) else Size(objSize, -1L)
        val args = PutObjectArgs.builder().bucket(bo.bucket).`object`(bo.fullName).stream(bo.input, size.itemSize, size.partSize).build()
        try {
            minio.putObject(args)
        } catch (e: Exception) {
            throw ServerException("上传数据失败", e)
        }
    }

    @Data
    private class Size(val itemSize: Long = 0L, val partSize: Long = 0L)
}
