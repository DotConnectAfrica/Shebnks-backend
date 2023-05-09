package com.md.shebanks.data.auth

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class AuthRequest(
    @NotNull(message = "Mobile number required")
    @Pattern(regexp = "^\\d{10}$")
    val mobile: String,
    @NotBlank(message = "Password  required")
    val password: String
)