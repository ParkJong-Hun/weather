package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device

import androidx.compose.ui.text.intl.Locale

actual val getLocale: String
    get() = Locale.current.language