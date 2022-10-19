package com.kop.gameserver.account

import jakarta.inject.Singleton
import java.util.*

@Singleton
class AccountService (private val repository: AccountRepository) {

  fun findOne(id: Int): Account? {
    return repository.findOne(id)
  }

  fun findByActName(actName: String): Account? {
    return repository.findByActName(actName)
  }
}