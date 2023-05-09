package com.md.shebanks.data.user.role

enum class UserPermission(val permission: String) {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),

    LOAN_READ("loan:read"),
    LOAN_WRITE("loan:write"),
    LOAN_DELETE("loan:delete"),

    LOAN_OFFICER_WRITE("officer:write"),
    LOAN_OFFICER_READ("officer:read"),
    LOAN_OFFICER_DELETE("officer:delete")
}