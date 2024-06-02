package domain.entity

internal class PermissionDeniedException(val permission: Permission) : RuntimeException()