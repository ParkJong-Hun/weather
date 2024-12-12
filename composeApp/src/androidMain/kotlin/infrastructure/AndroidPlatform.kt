import android.os.Build
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}