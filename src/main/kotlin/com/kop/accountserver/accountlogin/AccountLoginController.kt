package com.kop.accountserver.accountlogin

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory
import java.util.*

val <T> Optional<T>.value: T?
  get() = orElse(null)

@Controller("api/accountlogin")
class AccountLoginController(private val accountLoginService: AccountLoginService) {
  private val log = LoggerFactory.getLogger(AccountLoginController::class.java)

  @Get("/{id}")
  fun find(@PathVariable id: Int): HttpResponse<String?> {
    val accountLogin: AccountLogin? = accountLoginService.findById(id).value
    val name: String? = accountLogin?.name
    return HttpResponse.ok(name)
  }
}