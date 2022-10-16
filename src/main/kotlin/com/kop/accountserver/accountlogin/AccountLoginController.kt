package com.kop.accountserver.accountlogin

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory

@Controller("api/accountlogin")
class AccountLoginController(private val accountLoginService: AccountLoginService) {
  private val log = LoggerFactory.getLogger(AccountLoginController::class.java)

  @Get("/{id}")
  fun find(@PathVariable id: Int): HttpResponse<AccountLogin?> {
    try {
      val accountLogin: AccountLogin? = accountLoginService.findById(id).get()
      //val name: String? = accountLogin?.name
      return HttpResponse.ok(accountLogin)
    } catch (e: Exception) {
      log.error(e.message, e)
      return HttpResponse.serverError(null)
    }
  }
}