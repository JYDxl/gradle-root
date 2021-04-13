//package org.github.spring.rabbit
//
//import com.google.common.annotations.Beta
//import org.github.ops.objectMapper
//import org.springframework.amqp.core.Message
//import org.springframework.amqp.core.MessageProperties
//import org.springframework.amqp.core.MessageProperties.*
//import org.springframework.amqp.support.converter.SimpleMessageConverter
//import org.springframework.util.ClassUtils.getDefaultClassLoader
//import java.util.concurrent.ConcurrentHashMap
//
//@Beta
//class RabbitMessageConverter: SimpleMessageConverter() {
//
//  private val classLoader = requireNotNull(getDefaultClassLoader())
//
//  private val classCache = ConcurrentHashMap<String, Class<*>>()
//
//  override fun createMessage(msg: Any, props: MessageProperties): Message {
//    val bytes: ByteArray
//    when (msg) {
//      is ByteArray -> {
//        bytes = msg
//        props.contentType = CONTENT_TYPE_BYTES
//      }
//      is String    -> {
//        bytes = msg.toByteArray()
//        props.contentType = CONTENT_TYPE_TEXT_PLAIN
//      }
//      else         -> {
//        bytes = msg.toString().toByteArray()
//        props.contentType = CONTENT_TYPE_TEXT_PLAIN
//      }
//    }
//    props.contentLength = bytes.size.toLong()
//    return Message(bytes, props)
//  }
//
//  override fun fromMessage(msg: Message): Any {
//    val props = msg.messageProperties ?: return msg.body
//    val contentType = props.contentType ?: return msg.body
//    return when (contentType) {
//      CONTENT_TYPE_TEXT_PLAIN -> String(msg.body)
//      CONTENT_TYPE_JSON       -> objectMapper.readValue(msg.body, getClass(props.headers["class"] as String)) //TODO 缓存一下name到class的映射, 否则效率有问题
//      CONTENT_TYPE_BYTES      -> msg.body
//      else                    -> throw UnsupportedOperationException()
//    }
//  }
//
//  private fun getClass(clazz: String): Class<*> {
//    val target = classCache[clazz]
//    if (target != null) return target
//    val result: Class<*> = classLoader.loadClass(clazz)
//    classCache[clazz] = result
//    return result
//  }
//}
