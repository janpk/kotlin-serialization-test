package com.example

import io.smallrye.reactive.messaging.annotations.Broadcast
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter

@ApplicationScoped
class ExampleEmitter {

  @Channel("example-channel")
  private lateinit var emitter : Emitter<ExampleResponse>

  fun emitExample(exampleMessage: ExampleResponse) {
      emitter.send(exampleMessage)
  }
}
