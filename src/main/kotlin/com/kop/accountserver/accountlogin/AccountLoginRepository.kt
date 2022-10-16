package com.kop.accountserver.accountlogin

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AccountLoginRepository : JpaRepository<AccountLogin, Int> {
}