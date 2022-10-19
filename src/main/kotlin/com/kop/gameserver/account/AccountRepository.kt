package com.kop.gameserver.account

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.transaction.annotation.TransactionalAdvice
import java.util.*

@Repository("gameserver")
@TransactionalAdvice("gameserver")
interface AccountRepository : JpaRepository<Account, Int> {

  fun findOne(id: Int?): Account?
  fun findByActName(actName: String): Account?

  @Query(value = "SELECT MAX(a.id) + 1 FROM Account a")
  fun getNextId(): Int
}
