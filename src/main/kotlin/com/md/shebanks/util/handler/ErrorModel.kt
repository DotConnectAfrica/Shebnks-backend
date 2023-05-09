package com.md.shebanks.util.handler

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.http.HttpStatus
import java.util.*


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class ErrorModel(
    val error: Boolean = true,
    val status: HttpStatus,
    val timestamp: Date,
    val message: String
)
