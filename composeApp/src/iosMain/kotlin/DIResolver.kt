import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.component.KoinComponent

@OptIn(BetaInteropApi::class)
object DIResolver : KoinComponent {
    fun resolve(objCObject: Any): Any {
        if (objCObject is ObjCProtocol) {
            return resolve(objCProtocol = objCObject)
        }
        if (objCObject is ObjCClass) {
            return resolve(objCClass = objCObject)
        }
        throw Exception(message = "Unknown Object Type.")
    }

    /** Objective-C のクラスをヒントにしてインスタンスを取得 */
    private fun resolve(objCClass: ObjCClass): Any = getKoin().get(
        clazz = getOriginalKotlinClass(objCClass = objCClass)!!
    )

    /** Objective-C のプロトコルをヒントにしてインスタンスを取得 */
    private fun resolve(objCProtocol: ObjCProtocol): Any = getKoin().get(
        clazz = getOriginalKotlinClass(objCProtocol = objCProtocol)!!
    )
}

inline fun <reified T> inject(): T {
    return DIResolver.resolve(objCObject = T::class) as T
}