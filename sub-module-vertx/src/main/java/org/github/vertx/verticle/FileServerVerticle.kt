package org.github.vertx.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.CopyOptions
import java.nio.charset.StandardCharsets.UTF_8
import org.github.core.ops.error
import org.github.core.ops.log
import org.github.core.ops.trace

class FileServerVerticle: AbstractVerticle() {
  override fun start() {
    val fs = vertx.fileSystem()
    fs.readFile(".gitignore") {it: AsyncResult<Buffer> ->
      if (it.succeeded()) {
        log.trace {"文件[.gitignore]中的信息:\n${it.result().toString(UTF_8)}"}
      } else {
        it.cause().apply {
          log.error(this) {"文件读取失败"}
        }
      }
    }
    fs.copy(".gitignore", "build/.gitignore", CopyOptions().apply {isReplaceExisting = true}) {it: AsyncResult<Void> ->
      if (it.succeeded()) {
        log.trace {"文件拷贝成功"}
      } else {
        it.cause().apply {
          log.error(this) {"文件拷贝失败"}
        }
      }
    }
  }
}

private val log = FileServerVerticle::class.log
