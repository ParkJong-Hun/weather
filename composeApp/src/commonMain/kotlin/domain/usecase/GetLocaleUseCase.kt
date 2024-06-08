package domain.usecase

import domain.entity.Locale
import domain.gateway.device.LocaleService

interface GetLocaleUseCase {
    operator fun invoke(): Locale
}

class GetLocaleUseCaseImpl(
    private val localeService: LocaleService,
) : GetLocaleUseCase {
    override fun invoke(): Locale = localeService.getLocale()
}