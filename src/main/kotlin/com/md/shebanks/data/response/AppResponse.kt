package com.md.shebanks.data.response

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.http.HttpStatus

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class AppResponse(
    val message: String?,
    val status: HttpStatus,
    val data: Any? = null
)
