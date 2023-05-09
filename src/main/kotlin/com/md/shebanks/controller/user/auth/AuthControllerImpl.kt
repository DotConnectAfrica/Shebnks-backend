package com.md.shebanks.controller.user.auth

import com.md.shebanks.data.auth.AuthDatasource
import com.md.shebanks.data.auth.AuthRequest
import com.md.shebanks.data.auth.RegisterRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.service.user.auth.AuthServiceImpl
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequiredArgsConstructor
@RequestMapping("/she/api/v1/auth")
class AuthControllerImpl(val service: AuthServiceImpl) : AuthDatasource {

    @PostMapping("/register")
    override fun register(@Valid @RequestBody request: RegisterRequest): ResponseEntity<AppResponse> {
        return service.register(request)
    }

    @PostMapping("/login")
    override fun auth(@Valid @RequestBody request: AuthRequest): ResponseEntity<AppResponse> {
        return service.auth(request)
    }
}