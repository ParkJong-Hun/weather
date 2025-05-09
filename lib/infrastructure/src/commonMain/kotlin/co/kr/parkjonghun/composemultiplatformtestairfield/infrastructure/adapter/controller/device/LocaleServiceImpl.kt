package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocaleService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Locale

class LocaleServiceImpl : LocaleService {
    override fun getLocale(): Locale = Locale.fromLanguageCode(getLocale)
}