package com.md.shebanks.data.auth.config

import com.md.shebanks.repository.user.auth.AuthRepository
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class AuthConfigImpl(val repo: AuthRepository) : AuthConfig {

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username ->
            repo.findUserByMobile(username).orElseThrow { UsernameNotFoundException("User not found") }
        }
    }

    @Bean
    override fun authProvider(): AuthenticationProvider {
        val daoAuthProvider = DaoAuthenticationProvider()
        daoAuthProvider.setUserDetailsService(userDetailsService())
        daoAuthProvider.setPasswordEncoder(passwordEncoder())
        return daoAuthProvider
    }

    @Bean
    @Throws(Exception::class)
    override fun authManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }

    @Bean
    override fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}