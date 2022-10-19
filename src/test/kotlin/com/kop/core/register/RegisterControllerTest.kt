package com.kop.core.register

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@MicronautTest
class RegisterControllerTest {

  @Inject
  @field:Client("/")
  lateinit var client: HttpClient

  @Test
  @DisplayName("test POST '/api/register'")
  fun testRegister() {
    val e: HttpClientResponseException = assertThrows(HttpClientResponseException::class.java) {
      val cmd = RegisterCommand()
      cmd.username = "abcd"
      cmd.password = "thisisadummypassword"
      cmd.email = "notanemail"
      client.toBlocking().exchange(
        HttpRequest.POST("/api/register", cmd).accept(MediaType.APPLICATION_JSON),
        String::class.java
      )
    }
    val response: HttpResponse<*> = e.response
    val jsonString = response.body()
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatus())
  }
}