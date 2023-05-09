package com.md.shebanks.service.user.profile

import com.md.shebanks.data.profile.ProfileDatasource
import com.md.shebanks.data.profile.ProfileRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.repository.user.profile.ProfileRepository
import com.md.shebanks.util.handler.AppException
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@RequiredArgsConstructor
@Service
class ProfileServiceImpl(val repo: ProfileRepository) : ProfileDatasource {


    @Transactional
    override fun update(request: ProfileRequest, userId: String): ResponseEntity<AppResponse> {
        if (userId.isBlank()) throw (AppException("userId missing"))
        val profile = repo.findById(UUID.fromString(userId)).get()
        profile.email = request.email
        profile.firstName = request.firstName
        profile.lastName = request.lastName
        profile.middleName = request.middleName
        return ResponseEntity.ok(
            AppResponse(
                message = "User details updated",
                status = HttpStatus.OK,
                data = hashMapOf(
                    "user" to hashMapOf(
                        "firstName" to profile.firstName,
                        "lastName" to profile.lastName,
                        "middleName" to profile.middleName,
                        "email" to profile.email
                    )
                )
            )
        )
    }
}