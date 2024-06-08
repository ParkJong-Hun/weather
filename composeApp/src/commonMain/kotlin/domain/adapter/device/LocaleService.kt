package domain.adapter.device

import domain.entity.Locale

interface LocaleService {
    fun getLocale(): Locale
}