package com.example

import jakarta.enterprise.inject.Produces
import jakarta.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@Singleton
class CustomJsonProducer {

  @ExperimentalSerializationApi
  @Singleton
  @Produces
  fun customJson() = Json {
    coerceInputValues = true
    ignoreUnknownKeys = true
    explicitNulls = false
    allowStructuredMapKeys = true
    encodeDefaults = true
  }
}
