package com.kop.core.activation

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.transaction.annotation.TransactionalAdvice

@Repository("default")
@TransactionalAdvice("default")
interface ActivationRepository : JpaRepository<Activation, Int>
