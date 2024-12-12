package co.kr.parkjonghun.composemultiplatformtestairfield.domain

class PermissionDeniedException(val permission: Permission) : RuntimeException()