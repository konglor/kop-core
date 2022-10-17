package com.kop.core.activation

import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Version
import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@MappedEntity
open class Activation (
  @Id
  @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  open val id: Long? = null,

  @Version
  open val version: Long? = null,

  open val username: String? = null,
  open val email: String? = null,
  open val hash: String? = null,
  open val date: Date? = null
)