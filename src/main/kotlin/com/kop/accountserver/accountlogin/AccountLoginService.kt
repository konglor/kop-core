package com.kop.accountserver.accountlogin

import com.kop.core.register.RegisterCommand
import com.kop.core.register.RegisterMapper
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class AccountLoginService(private val repository: AccountLoginRepository) {
  @Inject
  protected lateinit var registerMapper: RegisterMapper
  fun findAll(): List<AccountLogin> {
    return repository.findAll()
  }

  fun findById(id: Int): Optional<AccountLogin> {
    return repository.findById(id)
  }

  fun createAccountLogin(registerCommand: RegisterCommand): AccountLogin {
    return repository.save(registerMapper.toAccountLogin(registerCommand))
  }
}
