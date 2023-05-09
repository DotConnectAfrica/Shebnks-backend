package com.md.shebanks.service.user.auth

import com.md.shebanks.data.DataMapTypeConverter
import com.md.shebanks.data.auth.AuthDatasource
import com.md.shebanks.data.auth.AuthRequest
import com.md.shebanks.data.auth.RegisterRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.data.user.UserModel
import com.md.shebanks.data.profile.UserProfileModel
import com.md.shebanks.data.user.role.UserRole
import com.md.shebanks.jwt.JwtServiceImpl
import com.md.shebanks.repository.user.auth.AuthRepository
import com.md.shebanks.repository.user.profile.ProfileRepository
import com.md.shebanks.util.handler.AppException
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


@RequiredArgsConstructor
@Service
class AuthServiceImpl(
    val repo: AuthRepository,
    val profileRepo: ProfileRepository,
    val passwordEncoder: PasswordEncoder,
    val jwtService: JwtServiceImpl,
    val authManager: AuthenticationManager
) : AuthDatasource {

    @OptIn(ExperimentalStdlibApi::class)
    override fun register(request: RegisterRequest): ResponseEntity<AppResponse> {
        val map = DataMapTypeConverter().map(request)
        for (e in map.entries) {
            if (e.value.isBlank()) throw (AppException("${e.key} cannot be null or empty"))
        }

        val exist = repo.findUserByMobile(request.mobile!!).getOrNull()
        if (exist != null) throw (AppException("Mobile number not available"))

        val user = UserModel(
            mobile = request.mobile!!,
            password = passwordEncoder.encode(request.password),
            role = UserRole.USER,
        )


        val s = repo.save(user)
        val p = profileRepo.save(
            UserProfileModel(
                userId = s.userId,
                firstName = request.firstName!!,
                middleName = request.middleName,
                lastName = request.lastName!!,
                email = request.email!!,
                idNumber = request.idNumber!!
            )
        )
        val jwtToken = jwtService.generateToken(user)

        return ResponseEntity.ok(
            AppResponse(
                message = "Hi welcome to She-banks",
                status = HttpStatus.OK,
                data = hashMapOf(
                    "token" to jwtToken,
                    "user" to hashMapOf(
                        "userId" to s.userId,
                        "mobile" to user.username,
                        "firstName" to p.firstName,
                        "lastName" to p.lastName,
                        "middleName" to p.middleName,
                        "email" to p.email,
                        "id" to p.idNumber
                    )
                )
            )
        )
    }

    override fun auth(request: AuthRequest): ResponseEntity<AppResponse> {

        val map = DataMapTypeConverter().map(request)
        for (e in map.entries) {
            if (e.value.isBlank()) throw (AppException("${e.key} cannot be null or empty"))
        }

        authManager.authenticate(
            UsernamePasswordAuthenticationToken(request.mobile, request.password)
        )

        val user = repo.findUserByMobile(request.mobile).get()
        val jwtToken = jwtService.generateToken(user)
        return ResponseEntity.ok(
            AppResponse(
                message = "Hi welcome to She-banks ${user.profile?.firstName}",
                status = HttpStatus.OK,
                data = hashMapOf(
                    "token" to jwtToken,
                    "user" to hashMapOf(
                        "userId" to user.userId,
                        "mobile" to user.username,
                        "firstName" to user.profile?.firstName,
                        "lastName" to user.profile?.lastName,
                        "middleName" to user.profile?.middleName,
                        "email" to user.profile?.email,
                        "id" to user.profile?.idNumber
                    )
                )
            )
        )
    }
}