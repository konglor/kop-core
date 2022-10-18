package com.kop.gameserver.account

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.transaction.annotation.TransactionalAdvice
import java.util.*

@Repository("gameserver")
@TransactionalAdvice("gameserver")
interface AccountRepository : JpaRepository<Account, Int> {
  fun findByActName(actName: String): Optional<Account>
}