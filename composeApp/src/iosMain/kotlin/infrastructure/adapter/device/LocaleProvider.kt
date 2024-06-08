package infrastructure.adapter.device

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual val getLocale: String
    get() = NSLocale.currentLocale.languageCode