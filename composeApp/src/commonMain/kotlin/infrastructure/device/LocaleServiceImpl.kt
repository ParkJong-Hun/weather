package infrastructure.device

import domain.entity.Locale
import domain.gateway.device.LocaleService

class LocaleServiceImpl : LocaleService {
    override fun getLocale(): Locale = Locale.fromLanguageCode(getLocale)
}