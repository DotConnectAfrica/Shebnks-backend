package com.md.shebanks.data.profile

import com.md.shebanks.data.response.AppResponse
import org.springframework.http.ResponseEntity

interface ProfileDatasource {
    fun update(request: ProfileRequest, userId: String): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }
}