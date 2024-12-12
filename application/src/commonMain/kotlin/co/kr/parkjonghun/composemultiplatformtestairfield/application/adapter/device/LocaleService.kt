package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Locale

interface LocaleService {
    fun getLocale(): Locale
}