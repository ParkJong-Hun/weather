import dev.icerock.moko.permissions.ios.PermissionsController
import org.koin.dsl.module

val iosNativeDIContainer = module {
    single<PermissionsController> { PermissionsController() }
}