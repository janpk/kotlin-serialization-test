package com.example

import java.nio.charset.StandardCharsets
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.apache.kafka.common.serialization.Deserializer

class CustomKotlinDeserializer : Deserializer<ExampleResponse> {
  override fun deserialize(topic: String, data: ByteArray): ExampleResponse {
    return Json.decodeFromString(data.toString(StandardCharsets.UTF_8))
  }
}
