package com.kop.gameserver.account

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account")
open class Account (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "act_id", nullable = false)
  open val id: Int? = null,

  @Column(name = "act_name", nullable = false)
  open val actName: String? = null,

  @Column(nullable = false)
  open val gm: Short? = null,

  @Column(name = "cha_ids", nullable = false)
  open val chaIds: String? = null,

  @Column(name = "last_ip", nullable = false)
  open val lastIp: String? = null,

  @Column(name = "disc_reason", nullable = false)
  open val discReason: String? = null
)