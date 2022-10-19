package com.kop.core.register

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
open class RegisterCommand {
  @NotBlank
  @Size(min = 5, max = 15)
  @Pattern(regexp = "^[a-zA-Z0-9]+\$", message = "username may only contain alphanumerics")
  open var username: String? = ""

  @NotBlank(message = "password must be provided")
  @Size(min = 8, max = 15)
  open var password: String? = ""

  @NotBlank
  @Size(min = 5, max = 50)
  @Pattern(regexp = ".+@.+\\..+", message = "email must be in valid email format")
  open var email: String? = ""
}
