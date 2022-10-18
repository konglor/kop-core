package com.kop.core.register

import com.kop.gameserver.account.Account
import com.kop.gameserver.account.AccountService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("api/register")
class RegisterController {
  private val log = LoggerFactory.getLogger(RegisterController::class.java)

  @Inject
  lateinit var accountService: AccountService

  @Post
  fun register(@Body @Valid dto: RegisterDto): HttpResponse<String> {
    try {
      val account = accountService.findByActName(dto.username)
      account.get()?.let {
        return HttpResponse.badRequest("username already exists")
      }
      return HttpResponse.ok("ok")
    } catch (e: Exception) {
      log.error(e.message, e)
      return HttpResponse.serverError(e.message)
    }
  }

}