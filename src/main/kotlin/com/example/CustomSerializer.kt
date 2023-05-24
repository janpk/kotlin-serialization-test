package com.example

import io.quarkus.logging.Log
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.kafka.common.serialization.Serializer

class CustomSerializer : Serializer<ExampleResponse> {
  @OptIn(ExperimentalSerializationApi::class)
  override fun serialize(topic: String, message: ExampleResponse): ByteArray {
    val format = Json {
      coerceInputValues = true
      ignoreUnknownKeys = true
      explicitNulls = false
      allowStructuredMapKeys = true
      encodeDefaults = true
    }
    Log.info("Korlin serialization result : ${format.encodeToString(message)}")
    val serializedString = format.encodeToString(message).toByteArray(Charsets.UTF_8)
    return serializedString
  }
}
