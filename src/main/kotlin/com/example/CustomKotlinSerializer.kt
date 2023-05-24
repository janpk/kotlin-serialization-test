package com.example

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.kafka.common.serialization.Serializer

class CustomKotlinSerializer : Serializer<ExampleResponse> {
  override fun serialize(topic: String, data: ExampleResponse): ByteArray {
    return Json.encodeToString(data).toByteArray(Charsets.UTF_8)
  }
}
