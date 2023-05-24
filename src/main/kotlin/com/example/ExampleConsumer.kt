package com.example

import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Incoming

@ApplicationScoped
class ExampleConsumer {


  @Incoming("example-channel")
  fun displayIncomingMessage(exampleMessage: ExampleResponse) {
    Log.info("Received: $exampleMessage")
  }
}
