package com.kop.core.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class TestController {

  @Inject
  @field:Client("/")
  lateinit var client: HttpClient

  @Test
  fun testTest() {
    val request: HttpRequest<String> = HttpRequest.GET("/test")
    val body = client.toBlocking().retrieve(request)
    assertNotNull(body)
    assertEquals("Hello", body)
  }
}