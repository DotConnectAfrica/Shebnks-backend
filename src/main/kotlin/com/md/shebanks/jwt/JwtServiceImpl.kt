package com.md.shebanks.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import javax.crypto.SecretKey


@Service
class JwtServiceImpl : JwtService {

    override fun extractUsername(token: String): String? {
        return extractClaim(token = token) { it.subject }
    }

    override fun generateToken(claims: Map<String, Objects>, userDetails: UserDetails): String {
        return Jwts.builder().setClaims(claims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(getSignKey(), SignatureAlgorithm.HS256).compact()
    }

    override fun generateToken(userDetails: UserDetails): String {
        return generateToken(hashMapOf(), userDetails = userDetails)
    }

    override fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    override fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    override fun extractExpiration(token: String): Date {
        return extractClaim(token = token) { it.expiration }
    }

    override fun <T> extractClaim(token: String, claimResolver: Function<Claims, T>): T {
        val claims = extractAllClaims(token)
        return claimResolver.apply(claims)
    }

    override fun extractAllClaims(token: String): Claims {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).body
    }

    override fun getSignKey(): SecretKey {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }

    override val secretKey: String
        get() = "482B4D6251655468566D597133743677397A24432646294A404E635266556A58"
}