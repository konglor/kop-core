package com.kop.core.register

import com.kop.accountserver.accountlogin.AccountLoginService
import com.kop.core.activation.ActivationService
import com.kop.gameserver.account.AccountService
import jakarta.inject.Inject
import javax.transaction.Transactional

class RegisterService {

  @Inject
  protected lateinit var accountLoginService: AccountLoginService

  @Inject
  protected lateinit var activationService: ActivationService

  @Inject
  protected lateinit var accountService: AccountService

  @Transactional
  fun createAccount(cmd: RegisterCommand) {
    accountLoginService.createAccountLogin(cmd)
    accountService.createAccount(cmd)
    activationService.create(cmd)
  }
}
