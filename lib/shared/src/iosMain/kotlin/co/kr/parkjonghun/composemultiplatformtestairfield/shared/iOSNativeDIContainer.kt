package co.kr.parkjonghun.composemultiplatformtestairfield.shared

import dev.icerock.moko.permissions.ios.PermissionsController
import dev.icerock.moko.permissions.ios.PermissionsControllerProtocol
import org.koin.dsl.module

val iosNativeDIContainer = module {
    single { PermissionsController() }
    single<PermissionsControllerProtocol> { get<PermissionsController>() }

    // FIXME: KClass for Objective-C classes is not supported yet
    //    single { CLLocationManager() }
}