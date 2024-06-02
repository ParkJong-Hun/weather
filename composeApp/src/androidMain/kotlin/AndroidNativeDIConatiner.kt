import dev.icerock.moko.permissions.PermissionsController
import org.koin.dsl.module

val androidNativeDIContainer = module {
    single<PermissionsController> { PermissionsController(applicationContext = get()) }
}