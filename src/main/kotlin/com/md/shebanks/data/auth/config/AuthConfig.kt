package com.md.shebanks.data.auth.config

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder

interface AuthConfig {
    fun userDetailsService(): UserDetailsService
    fun authProvider(): AuthenticationProvider
    fun authManager(config: AuthenticationConfiguration): AuthenticationManager
    fun passwordEncoder(): PasswordEncoder?
}