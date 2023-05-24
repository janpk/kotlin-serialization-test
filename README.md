# kotlin-serialization-test

This branch adds kafka to the dependencies with default setup.

```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-smallrye-reactive-messaging-kafka</artifactId>
    </dependency>
```
For testing, the smallrye kafka copanion is used

```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-test-kafka-companion</artifactId>
      <scope>test</scope>
    </dependency>
```

To serialize objects with kotlinx serialization, custom serdes implementations have to be created. It is simple, it's just implementing the kafka interfaces and call kotlinx serialization classes. 

```kotlin
class CustomKotlinSerializer : Serializer<ExampleResponse> {
  override fun serialize(topic: String, data: ExampleResponse): ByteArray {
    return Json.encodeToString(data).toByteArray(Charsets.UTF_8)
  }
}
```
```kotlin
class CustomKotlinDeserializer : Deserializer<ExampleResponse> {
  override fun deserialize(topic: String, data: ByteArray): ExampleResponse {
    return Json.decodeFromString(data.toString(StandardCharsets.UTF_8))
  }
}
```



Running

```bash
./mvnw clean test
```
is succesful.
