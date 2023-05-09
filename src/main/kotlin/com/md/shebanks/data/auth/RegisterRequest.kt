package com.md.shebanks.data.auth

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class RegisterRequest(

    @NotBlank(message = "Mobile number required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    var mobile: String?,

    @NotBlank(message = "Password  required")
    var password: String?,

    @NotBlank(message = "First name required")
    var firstName: String?,

    var middleName: String?,

    @NotBlank(message = "Last name required")
    var lastName: String?,

    @NotBlank(message = "Email required")
    @Email(message = "Invalid email address")
    var email: String?,

    @NotBlank(message = "ID number required")
    var idNumber: String?
)
