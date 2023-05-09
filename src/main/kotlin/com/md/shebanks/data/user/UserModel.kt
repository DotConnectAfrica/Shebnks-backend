package com.md.shebanks.data.user

import com.md.shebanks.data.loan.LoanApplicationModel
import com.md.shebanks.data.loan.user.UserQualifiedLoanModel
import com.md.shebanks.data.profile.UserProfileModel
import com.md.shebanks.data.user.role.UserRole
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user_table")
data class UserModel(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var userId: UUID? = null,

    @Column(unique = true)
    private var mobile: String,

    private var password: String,

    @Enumerated(EnumType.STRING)
    val role: UserRole,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    val profile: UserProfileModel? = null,

    @OneToMany(mappedBy = "loanApplicant")
    var loan: MutableList<LoanApplicationModel>? = null,

    @OneToMany(mappedBy = "loanProduct")
    var product: MutableList<UserQualifiedLoanModel>? = null

) : UserDetails {

    override fun getAuthorities(): Set<GrantedAuthority> {
        return role.authorities()
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return mobile
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}