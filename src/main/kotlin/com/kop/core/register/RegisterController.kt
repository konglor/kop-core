package com.kop.core.register

import com.kop.extension.toMD5
import com.kop.gameserver.account.AccountService
import io.micronaut.core.version.annotation.Version
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
class RegisterController(private val registerService: RegisterService) {
  private val log = LoggerFactory.getLogger(RegisterController::class.java)

  @Inject
  lateinit var accountService: AccountService

  @Version("1")
  @Post
  fun register(@Body @Valid cmd: RegisterCommand): HttpResponse<String> { // ktlint-disable annotation
    try {
      val account = cmd.username?.let { accountService.findByActName(it) }
      account?.let {
        return HttpResponse.badRequest("username already exists")
      }
      registerService.createAccount(cmd)
      return HttpResponse.ok("ok")
    } catch (e: Exception) {
      log.error(e.message, e)
      return HttpResponse.serverError(e.message)
    }
  }
}
