package co.kr.parkjonghun.composemultiplatformtestairfield.domain

class PermissionDeniedAlwaysException(val permission: Permission) : RuntimeException()