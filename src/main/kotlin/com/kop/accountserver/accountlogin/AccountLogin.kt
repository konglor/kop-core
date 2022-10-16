package com.kop.accountserver.accountlogin

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account_login")
open class AccountLogin (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  open val id: Int? = null,

  @Column(name = "name", nullable = true)
  open val name: String? = null,

  @Column(name = "password", nullable = true)
  open val password: String? = null,

  //@Column(name = "originalPassword", nullable = true)
  //open val originalPassword: String? = null,

  @Column(name = "sid", nullable = false)
  open val sid: Int? = null,

  @Column(name = "login_status", nullable = true)
  open val loginStatus: Int? = null,

  @Column(name = "enable_login_tick", nullable = true)
  open val enableLoginTick: Long? = null,

  @Column(name = "login_group", nullable = true)
  open val loginGroup: String? = null
)