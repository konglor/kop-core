package com.kop.accountserver.accountlogin

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.transaction.annotation.TransactionalAdvice

@Repository("accountserver")
@TransactionalAdvice("accountserver")
interface AccountLoginRepository : JpaRepository<AccountLogin, Int>
