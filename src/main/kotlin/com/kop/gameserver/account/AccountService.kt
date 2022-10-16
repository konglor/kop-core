package com.kop.gameserver.account

import jakarta.inject.Singleton
import java.util.*

@Singleton
class AccountService (private val repository: AccountRepository) {

  fun findById(id: Int): Optional<Account> {
    return repository.findById(id)
  }
}