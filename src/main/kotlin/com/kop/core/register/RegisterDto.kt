package com.kop.core.register

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
class RegisterDto {
  @NotBlank
  @Size(min = 5, max = 15)
  @Pattern(regexp = "^[a-zA-Z0-9]+\$", message = "username may only contain alphanumerics")
  open val username: String = ""

  @NotBlank(message = "password must be provided")
  @Size(min = 8, max = 15)
  open val password: String = ""

  @NotBlank
  @Size(min = 5, max = 50)
  @Pattern(regexp = ".+@.+\\..+", message = "email must be in valid email format")
  open val email: String = ""
}