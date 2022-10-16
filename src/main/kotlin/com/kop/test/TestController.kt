package com.kop.test

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.slf4j.LoggerFactory

@Controller("/test")
class TestController {
  private val log = LoggerFactory.getLogger(TestController::class.java)

  @Get("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  fun hello(): HttpResponse<String> {
    try {
      log.info("ok")
      return HttpResponse.ok("hello")
    } catch (e: Exception) {
      log.error(e.message)
      return HttpResponse.serverError()
    }
  }

}