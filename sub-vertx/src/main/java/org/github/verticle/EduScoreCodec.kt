package org.github.verticle

import io.vertx.core.buffer.Buffer
import io.vertx.core.eventbus.MessageCodec
import io.vertx.core.json.JsonObject

class EduScoreCodec: MessageCodec<EduScore, EduScore> {
  override fun decodeFromWire(pos: Int, buffer: Buffer): EduScore {
    val length = buffer.getInt(pos)
    val newPos = pos + 4
    val json = JsonObject(buffer.slice(newPos, newPos + length))
    return json.mapTo(EduScore::class.java)!!
  }

  override fun encodeToWire(buffer: Buffer, eduScore: EduScore) {
    val json = JsonObject.mapFrom(eduScore)!!
    val encoded = json.toBuffer()!!
    buffer.appendInt(encoded.length())
    buffer.appendBuffer(encoded)
  }

  override fun systemCodecID() = (-1).toByte()

  override fun transform(eduScore: EduScore) = JsonObject.mapFrom(eduScore).copy().mapTo(EduScore::class.java)!!

  override fun name() = "eduScore"
}
