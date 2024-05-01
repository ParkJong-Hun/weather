package domain.usecase

import domain.gateway.platform.getPlatform

class GreetingUseCase {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}