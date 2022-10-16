package com.kop.accountserver.accountlogin

import jakarta.inject.Singleton
import java.util.*

@Singleton
class AccountLoginService(private val repository: AccountLoginRepository) {
  fun findAll(): List<AccountLogin> {
    return repository.findAll()
  }

  fun findById(id: Int): Optional<AccountLogin> {
    return repository.findById(id)
  }
}