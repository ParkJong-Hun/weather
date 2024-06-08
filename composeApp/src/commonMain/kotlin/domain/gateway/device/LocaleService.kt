package domain.gateway.device

import domain.entity.Locale

interface LocaleService {
    fun getLocale(): Locale
}