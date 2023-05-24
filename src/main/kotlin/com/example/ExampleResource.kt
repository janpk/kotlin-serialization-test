package com.example

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  fun hello(): ExampleResponse {
    val response = ExampleResponse(greeting = "Hello from RESTEasy Reactive", nullable = null)
    return response
  }
}
