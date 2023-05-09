package com.md.shebanks.data.user.role

import com.google.common.collect.Sets
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors

enum class UserRole(permission: Set<UserPermission>) {
    USER(Sets.newHashSet()),
    ADMIN(
        Sets.newHashSet(
            UserPermission.LOAN_READ,
            UserPermission.LOAN_WRITE,
            UserPermission.LOAN_DELETE,
            UserPermission.USER_WRITE,
            UserPermission.USER_READ,
            UserPermission.USER_DELETE,
            UserPermission.LOAN_OFFICER_WRITE,
            UserPermission.LOAN_OFFICER_READ,
            UserPermission.LOAN_OFFICER_DELETE
        )
    ),

    LOAN_OFFICER(Sets.newHashSet()),

    COMPLIANCE_OFFICER(Sets.newHashSet());


    private val permissions: Set<UserPermission> = permission

    fun authorities(): Set<SimpleGrantedAuthority> {
        val permissions = permissions.stream()
            .map { auth -> SimpleGrantedAuthority(auth.permission) }.collect(Collectors.toSet())
        permissions.add(SimpleGrantedAuthority("ROLE_${this.name}"))
        return permissions
    }

}