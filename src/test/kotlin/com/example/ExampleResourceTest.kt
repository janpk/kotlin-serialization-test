package com.example

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.kafka.InjectKafkaCompanion
import io.quarkus.test.kafka.KafkaCompanionResource
import io.restassured.RestAssured.given
import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

@QuarkusTest
@QuarkusTestResource(KafkaCompanionResource::class)
class ExampleResourceTest {

  @InjectKafkaCompanion lateinit var companion: KafkaCompanion

  @Test
  fun testHelloEndpoint() {
    given()
        .`when`()
        .get("/hello")
        .then()
        .statusCode(200)
        .log()
        .all()
        .body(
            "$",
            hasKey("defaultValue"),
            "$",
            not(hasKey("nullable")),
            "greeting",
            `is`("Hello from RESTEasy Reactive"),
        )

    companion.registerSerde(
        ExampleResponse::class.java, CustomKotlinSerializer(), CustomKotlinDeserializer())

    val task = companion.consume(ExampleResponse::class.java).fromTopics("example-topic", 1)
    task.awaitCompletion()
    println(task.firstRecord.value())
    assertEquals(1, task.count())
    val response = task.firstRecord.value()
    assertEquals("none", response.defaultValue)
    assertNull(response.nullable)
  }
}
