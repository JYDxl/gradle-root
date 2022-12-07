package org.github.vertx.ops

import com.google.common.base.Strings.padEnd
import io.vertx.core.DeploymentOptions
import io.vertx.core.Promise
import io.vertx.core.Verticle
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.Message
import io.vertx.core.eventbus.MessageConsumer
import io.vertx.core.json.Json.encode
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.toReceiveChannel
import kotlinx.coroutines.channels.ReceiveChannel
import org.github.vertx.const.Consumers
import org.github.vertx.model.BufferAble
import org.github.vertx.model.fromBuffer
import org.github.core.ops.info
import org.github.core.ops.log
import org.slf4j.Logger
import java.util.function.Supplier
import kotlin.reflect.KClass

inline fun <reified T: BufferAble, reified R: BufferAble> Vertx.consumer(consumers: Consumers, maxBufferSize: Int = 100): ReceiveChannel<Message<Buffer>> {
  val address = consumers.toString()
  val consumer: MessageConsumer<Buffer> = eventBus().consumer(address)
  log.info {"[CONSUMER注册成功] ${address.pad("ADDRESS:")} | ${T::class.pad("EXPECTED:")} | REPLY:${R::class.java.name}"}
  return consumer.setMaxBufferedMessages(maxBufferSize).toReceiveChannel(this)
}

suspend inline fun <reified T: BufferAble, reified R: BufferAble> Vertx.requestAwait(consumers: Consumers, message: T, options: DeliveryOptions = defaultDeliveryOptions): Pair<Message<Buffer>, R> {
  val res = eventBus().request<Buffer>(consumers.toString(), message.toBuffer(), options).await()
  val body = fromBuffer<R>(res.body())
  return Pair(res, body)
}

suspend inline fun <reified T: Verticle> Vertx.deploySupplier(verticle: Supplier<T>, options: DeploymentOptions = defaultDeploymentOptions) {
  @Suppress("UNCHECKED_CAST") val id = deployVerticle(verticle as Supplier<Verticle>, options).await()
  log.deploySuccess(id, T::class, options)
}

suspend fun Vertx.deploy(verticle: Verticle, options: DeploymentOptions = defaultDeploymentOptions) {
  val id = deployVerticle(verticle, options).await()
  log.deploySuccess(id, verticle::class, options)
}

suspend fun <T> Vertx.executeAwait(ordered: Boolean = false, blockingCodeHandler: () -> T?): T = executeBlocking(
  {it: Promise<T> ->
    try {
      it.complete(blockingCodeHandler())
    } catch (e: Exception) {
      it.fail(e)
    }
  }, ordered
).await()

fun String.pad(prefix: String): String {
  val body = padEnd(this, minLen, ' ').takeLast(minLen)
  return padEnd(prefix + body, maxLen, ' ').takeLast(maxLen)
}

fun KClass<*>.pad(prefix: String) = java.name.pad(prefix)

fun Logger.deploySuccess(id: String, clazz: KClass<out Verticle>, options: DeploymentOptions) {
  info {"[VERTICLE部署成功] ${id.pad("ID:")} | ${clazz.pad("CLASS:")} | OPTIONS:${encode(options)}"}
}

const val maxLen = 40

const val minLen = 30

val defaultDeploymentOptions = DeploymentOptions()

val defaultDeliveryOptions = DeliveryOptions()

val log = VertxOps::class.log

class VertxOps
