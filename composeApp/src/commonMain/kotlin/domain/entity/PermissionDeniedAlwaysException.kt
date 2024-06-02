package domain.entity

internal class PermissionDeniedAlwaysException(val permission: Permission) : RuntimeException()