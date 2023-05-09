package com.md.shebanks.controller.user.profile

import com.md.shebanks.data.profile.ProfileDatasource
import com.md.shebanks.data.profile.ProfileRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.service.user.profile.ProfileServiceImpl
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequiredArgsConstructor
@RequestMapping("/she/api/v1/user/profile")
class ProfileControllerImpl(
    val service: ProfileServiceImpl
) : ProfileDatasource {


    @PutMapping("/update/{userId}")
    override fun update(
        @RequestBody request: ProfileRequest,
        @PathVariable userId: String
    ): ResponseEntity<AppResponse> {
        return service.update(request, userId)
    }
}