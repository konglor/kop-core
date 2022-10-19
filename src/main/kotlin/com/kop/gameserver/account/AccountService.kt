package com.kop.gameserver.account

import com.kop.core.register.RegisterCommand
import com.kop.core.register.RegisterMapper
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class AccountService(private val repository: AccountRepository) {
  private val log = LoggerFactory.getLogger(AccountService::class.java)

  @Inject
  protected lateinit var registerMapper: RegisterMapper

  fun findOne(id: Int): Account? {
    return repository.findOne(id)
  }

  fun findByActName(actName: String): Account? {
    return repository.findByActName(actName)
  }

  fun createAccount(registerCommand: RegisterCommand): Account {
    val account = registerMapper.toAccount(registerCommand)
    account.id = repository.getNextId()
    return repository.save(account)
  }
}
