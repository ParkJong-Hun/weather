package co.kr.parkjonghun.composemultiplatformtestairfield.domain

enum class Locale(val languageCode: String) {
    JAPANESE("ja"),
    ENGLISH("en"),
    CHINESE("zh"),
    KOREAN("ko"),

    // Default language is english
    UNKNOWN("en"),
    ;

    companion object {
        fun fromLanguageCode(languageCode: String): Locale {
            return Locale.entries.find { it.languageCode == languageCode } ?: UNKNOWN
        }
    }
}