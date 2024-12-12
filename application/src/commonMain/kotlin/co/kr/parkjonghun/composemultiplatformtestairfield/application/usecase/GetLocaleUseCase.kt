package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocaleService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Locale

interface GetLocaleUseCase {
    operator fun invoke(): Locale
}

class GetLocaleUseCaseImpl(
    private val localeService: LocaleService,
) : GetLocaleUseCase {
    override fun invoke(): Locale = localeService.getLocale()
}