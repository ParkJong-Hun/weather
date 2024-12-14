package co.kr.parkjonghun.composemultiplatformairfield.shared

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.Qualifier

@OptIn(BetaInteropApi::class)
object DIResolver : KoinComponent {
    fun resolve(instance: Any, qualifier: Qualifier?): Any {
        return when (instance) {
            is ObjCProtocol -> getObjCProtocol(
                objCProtocol = instance,
                qualifier = qualifier,
            )

            is ObjCClass -> getObjCClass(objCClass = instance, qualifier = qualifier)

            else -> resolveAny(any = instance, qualifier = qualifier)
        }
    }

    private fun getObjCProtocol(objCProtocol: ObjCProtocol, qualifier: Qualifier?): Any =
        getKoin().get(
            clazz = getOriginalKotlinClass(objCProtocol = objCProtocol)!!,
            qualifier = qualifier,
        )

    private fun getObjCClass(objCClass: ObjCClass, qualifier: Qualifier?): Any = getKoin().get(
        clazz = getOriginalKotlinClass(objCClass = objCClass)!!,
        qualifier = qualifier,
    )

    private fun resolveAny(any: Any, qualifier: Qualifier?): Any = getKoin().get(
        clazz = any::class,
        qualifier = qualifier,
    )
}

inline fun <reified T> inject(qualifier: Qualifier? = null): T {
    return DIResolver.resolve(instance = T::class, qualifier) as T
}

//inline fun <reified T> injectForIos(qualifier: Qualifier? = null): T {
//    return (DIResolver.resolve(
//        instance = IosDependencyWrapper::class,
//        qualifier = qualifier,
//    ) as IosDependencyWrapper).instance as T
//}