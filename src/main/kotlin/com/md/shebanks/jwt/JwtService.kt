package com.md.shebanks.jwt

import io.jsonwebtoken.Claims
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.function.Function
import javax.crypto.SecretKey

interface JwtService {
    fun extractUsername(token: String): String?
    fun generateToken(claims: Map<String, Objects>, userDetails: UserDetails): String
    fun generateToken(userDetails: UserDetails): String
    fun isTokenValid(token: String, userDetails: UserDetails): Boolean
    fun isTokenExpired(token: String): Boolean
    fun extractExpiration(token: String): Date
    fun <T> extractClaim(token: String, claimResolver: Function<Claims, T>): T
    fun extractAllClaims(token: String): Claims
    fun getSignKey(): SecretKey
    val secretKey: String
}