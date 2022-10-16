package com.kop.gameserver.account

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.transaction.annotation.TransactionalAdvice

@Repository("gameserver")
@TransactionalAdvice("gameserver")
interface AccountRepository : JpaRepository<Account, Int> {
}