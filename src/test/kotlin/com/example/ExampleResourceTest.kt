package com.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

  @Test
  fun testHelloEndpoint() {
    given()
      .`when`().get("/hello")
      .then()
      .statusCode(200)
      .log()
      .all()
      .body(
        "greeting", `is`("Hello from RESTEasy Reactive"),
      )
  }

}
