package domain.usecase

import domain.entity.Locale
import infrastructure.device.getLocale

interface GetLocaleUseCase {
    operator fun invoke(): Locale
}

class GetLocaleUseCaseImpl : GetLocaleUseCase {
    override fun invoke(): Locale = Locale.fromLanguageCode(getLocale)
}