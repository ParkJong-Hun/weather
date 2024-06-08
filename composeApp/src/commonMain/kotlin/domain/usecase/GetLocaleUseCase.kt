package domain.usecase

import domain.adapter.device.LocaleService
import domain.entity.Locale

interface GetLocaleUseCase {
    operator fun invoke(): Locale
}

class GetLocaleUseCaseImpl(
    private val localeService: LocaleService,
) : GetLocaleUseCase {
    override fun invoke(): Locale = localeService.getLocale()
}