package com.kop.gameserver.account

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory

@Controller("api/account")
class AccountController(private val accountService: AccountService) {
  private val log = LoggerFactory.getLogger(AccountController::class.java)

  @Get("/{id}")
  fun find(@PathVariable id: Int): HttpResponse<Account?> {
    try {
      val account: Account? = accountService.findById(id).get()
      return HttpResponse.ok(account)
    } catch (e: Exception) {
      log.error(e.message, e)
      return HttpResponse.serverError(null)
    }
  }
}