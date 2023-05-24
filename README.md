# kotlin-serialization-test

This branch contains the default configuration after running the quarkus starter with dependency

```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-reactive-kotlin-serialization</artifactId>
    </dependency>
```

Changes from the generated starter app:

- Added ExampleResponse class with kotlinx.serialization ```@Serializable``` annotation and returing the data class from the rest endpoint

```kotlin
@Serializable
data class ExampleResponse(
```
kotlinx.serialization does not work out of the box. The quarkus code starter do not configure kotlin serialization with the kotlin compiler.

Running 

```bash
./mvnw clean test
```

will give

```
2023-05-24 08:03:58,605 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-1) HTTP Request to /hello failed, error id: 9cabfcf6-99b9-4c9b-a808-ed23a2614954-1: kotlinx.serialization.SerializationException: Serializer for class 'ExampleResponse' is not found.
Please ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.

        at kotlinx.serialization.internal.PlatformKt.serializerNotRegistered(Platform.kt:31)
        at kotlinx.serialization.SerializersKt__SerializersJvmKt.serializer(SerializersJvm.kt:77)
        at kotlinx.serialization.SerializersKt.serializer(Unknown Source)
        at kotlinx.serialization.SerializersKt__SerializersJvmKt.serializer(SerializersJvm.kt:36)
        at kotlinx.serialization.SerializersKt.serializer(Unknown Source)
        at io.quarkus.resteasy.reactive.kotlin.serialization.runtime.KotlinSerializationMessageBodyWriter.writeResponse(KotlinSerializationMessageBodyWriter.kt:45)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:227)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:195)
        at org.jboss.resteasy.reactive.server.core.serialization.FixedEntityWriter.write(FixedEntityWriter.java:28)
        at org.jboss.resteasy.reactive.server.handlers.ResponseWriterHandler.handle(ResponseWriterHandler.java:34)
        at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:147)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
        at io.quarkus.vertx.core.runtime.VertxCoreRecorder$14.runWith(VertxCoreRecorder.java:576)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1538)
        at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
        at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:833)

```
