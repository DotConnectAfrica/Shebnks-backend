package com.md.shebanks.data.profile

import com.md.shebanks.data.user.UserModel
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.UUID


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user_profile_table")
data class UserProfileModel(
    @Id
    var userId: UUID? = null,
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    var email: String,
    var idNumber: String,
    var avatar: String? = null,
    @OneToOne(mappedBy = "profile")
    private var user: UserModel? = null
)
