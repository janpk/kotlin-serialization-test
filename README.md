# kotlin-serialization-test

This branch contains a custom configuration of kotlinx.serialization. A custom producer is added to configure the serialization 

```kotlin
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
```

Running

```bash
./mvnw clean test
```

is successful.
