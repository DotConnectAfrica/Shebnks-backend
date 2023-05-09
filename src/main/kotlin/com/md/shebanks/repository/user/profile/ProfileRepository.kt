package com.md.shebanks.repository.user.profile

import com.md.shebanks.data.profile.UserProfileModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProfileRepository : JpaRepository<UserProfileModel, UUID> {
    override fun findById(id: UUID): Optional<UserProfileModel>
}