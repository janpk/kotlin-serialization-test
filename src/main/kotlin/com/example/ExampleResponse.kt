package com.example

import kotlinx.serialization.Serializable

@Serializable
data class ExampleResponse(
    val greeting: String,
    val defaultValue: String = "none",
    val nullable: String?
)
