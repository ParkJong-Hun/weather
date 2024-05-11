package domain.usecase

import domain.gateway.platform.getPlatform

interface GreetingUseCase {
    fun greet(): String
}

class GreetingUseCaseImpl : GreetingUseCase {
    private val platform = getPlatform()

    override fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}