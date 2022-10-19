package com.kop.core.activation

import com.kop.core.register.RegisterCommand
import com.kop.core.register.RegisterMapper
import jakarta.inject.Inject

class ActivationService(private val repository: ActivationRepository) {

  @Inject
  protected lateinit var registerMapper: RegisterMapper

  fun create(registerCommand: RegisterCommand): Activation {
    return repository.save(registerMapper.toActivation(registerCommand))
  }
}
