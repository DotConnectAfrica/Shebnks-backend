package com.md.shebanks.data.profile

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class ProfileRequest(
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    var email: String,
    var avatar: String? = null,
)
