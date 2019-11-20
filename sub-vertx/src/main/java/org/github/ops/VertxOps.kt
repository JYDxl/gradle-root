package org.github.ops

import com.google.common.base.Strings.*
import io.vertx.core.DeploymentOptions
import io.vertx.core.Verticle
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.Message
import io.vertx.core.eventbus.MessageConsumer
import io.vertx.core.eventbus.impl.HandlerRegistration.*
import io.vertx.core.json.Json.*
import io.vertx.kotlin.core.deployVerticleAwait
import io.vertx.kotlin.core.eventbus.requestAwait
import io.vertx.kotlin.core.executeBlockingAwait
import io.vertx.kotlin.coroutines.toChannel
import kotlinx.coroutines.channels.ReceiveChannel
import org.github.const.Consumers
import org.github.model.BufferAble
import org.github.model.fromBuffer
import org.slf4j.Logger
import java.util.function.Supplier
import kotlin.reflect.KClass

inline fun <reified T: BufferAble, reified R: BufferAble> Vertx.consumer(consumers: Consumers, maxBufferSize: Int = DEFAULT_MAX_BUFFERED_MESSAGES): ReceiveChannel<Message<Buffer>> {
  val address = consumers.toString()
  val consumer: MessageConsumer<Buffer> = eventBus().consumer<Buffer>(address)
  logger.info { "[CONSUMER注册成功] ${address.pad("ADDRESS:")} | ${T::class.pad("EXPECTED:")} | REPLY:${R::class.java.name}" }
  return consumer.setMaxBufferedMessages(maxBufferSize).toChannel(this)
}

suspend inline fun <reified T: BufferAble, reified R: BufferAble> Vertx.requestAwait(consumers: Consumers, message: T, options: DeliveryOptions = defaultDeliveryOptions): Pair<Message<Buffer>, R> {
  val res = eventBus().requestAwait<Buffer>(consumers.toString(), message.toBuffer(), options)
  val body = fromBuffer<R>(res.body())
  return Pair(res, body)
}

suspend inline fun <reified T: Verticle> Vertx.deploySupplier(verticle: Supplier<T>, options: DeploymentOptions = defaultDeploymentOptions) {
  @Suppress("UNCHECKED_CAST") val id = deployVerticleAwait(verticle as Supplier<Verticle>, options)
  logger.deploySuccess(id, T::class, options)
}

suspend fun Vertx.deploy(verticle: Verticle, options: DeploymentOptions = defaultDeploymentOptions) {
  val id = deployVerticleAwait(verticle, options)
  logger.deploySuccess(id, verticle::class, options)
}

suspend fun <T> Vertx.executeAwait(ordered: Boolean = false, blockingCodeHandler: () -> T?) = executeBlockingAwait<T>(
  {
    try {
      it.complete(blockingCodeHandler())
    } catch(e: Exception) {
      it.fail(e)
    }
  }, ordered)

fun String.pad(prefix: String): String {
  val body = padEnd(this, minLen, ' ').takeLast(minLen)
  return padEnd(prefix + body, maxLen, ' ').takeLast(maxLen)
}

fun KClass<*>.pad(prefix: String) = java.name.pad(prefix)

fun Logger.deploySuccess(id: String, clazz: KClass<out Verticle>, options: DeploymentOptions) {
  info { "[VERTICLE部署成功] ${id.pad("ID:")} | ${clazz.pad("CLASS:")} | OPTIONS:${encode(options)}" }
}

const val maxLen = 40

const val minLen = 30

val defaultDeploymentOptions = DeploymentOptions()

val defaultDeliveryOptions = DeliveryOptions()

val logger = "org.github.VertxOps".log
