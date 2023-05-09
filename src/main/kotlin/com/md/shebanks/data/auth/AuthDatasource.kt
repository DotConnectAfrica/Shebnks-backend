package com.md.shebanks.data.auth

import com.md.shebanks.data.response.AppResponse
import org.springframework.http.ResponseEntity

interface AuthDatasource {

    fun register(request: RegisterRequest): ResponseEntity<AppResponse>
    fun auth(request: AuthRequest): ResponseEntity<AppResponse>
}