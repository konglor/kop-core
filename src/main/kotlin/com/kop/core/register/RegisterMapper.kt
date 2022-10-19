package com.kop.core.register

import com.kop.accountserver.accountlogin.AccountLogin
import com.kop.core.activation.Activation
import com.kop.extension.toMD5
import com.kop.gameserver.account.Account
import jakarta.inject.Singleton

@Singleton
class RegisterMapper {

  fun toAccount(cmd: RegisterCommand): Account {
    val passwordMd5 = cmd.password?.toMD5()
    return Account(
      actName = cmd.username,
      password = passwordMd5,
      gm = 0,
      chaIds = "",
      discReason = "",
      lastIp = ""
    )
  }

  fun toAccountLogin(cmd: RegisterCommand): AccountLogin {
    val passwordMd5 = cmd.password?.toMD5()
    return AccountLogin(
      name = cmd.username,
      password = passwordMd5,
      originalPassword = cmd.password,
      ban = 1,
      sid = 0
    )
  }

  fun toActivation(cmd: RegisterCommand): Activation {
    val usernameMd5 = cmd.username?.toMD5()
    return Activation(
      username = cmd.username,
      email = cmd.email,
      hash = usernameMd5
    )
  }
}
