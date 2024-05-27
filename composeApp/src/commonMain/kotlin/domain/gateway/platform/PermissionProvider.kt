package domain.gateway.platform

import domain.entity.Permission

expect fun checkPermission(permissions: List<Permission>): Boolean