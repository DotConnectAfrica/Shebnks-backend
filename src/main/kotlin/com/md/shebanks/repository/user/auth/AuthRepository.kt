package com.md.shebanks.repository.user.auth

import com.md.shebanks.data.user.UserDatasource
import com.md.shebanks.data.user.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthRepository : JpaRepository<UserModel, UUID>, UserDatasource {

    override fun findById(id: UUID): Optional<UserModel>

    override fun findUserByMobile(mobile: String): Optional<UserModel>
}