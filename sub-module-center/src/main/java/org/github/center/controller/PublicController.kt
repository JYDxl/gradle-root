package org.github.center.controller

import org.github.center.SERVER_CENTER_NAME
import org.github.core.minio.MinioUploadBo
import org.github.core.minio.MinioWrapper
import org.github.core.spring.restful.Returnable
import org.github.core.spring.restful.json.JSONReturn
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource

@RestController
@RequestMapping("/public/")
class PublicController {
  @Resource
  private lateinit var minioWrapper: MinioWrapper

  @PostMapping("save")
  fun save(file: MultipartFile): Returnable {
    val bo = MinioUploadBo().apply {
      bucket = SERVER_CENTER_NAME
      name = file.originalFilename
      input = file.inputStream
      objSize = file.size
      path = ""
    }

    minioWrapper.upload(bo)
    return JSONReturn.ok()
  }
}
