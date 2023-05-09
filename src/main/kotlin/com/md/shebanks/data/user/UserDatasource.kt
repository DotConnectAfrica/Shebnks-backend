package com.md.shebanks.data.user

import java.util.*

interface UserDatasource {

    fun findUserByMobile(mobile: String): Optional<UserModel> {
        throw Exception("Not implemented")
    }
}