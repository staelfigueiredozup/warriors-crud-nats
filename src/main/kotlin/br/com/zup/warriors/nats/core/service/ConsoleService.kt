package br.com.zup.warriors.nats.core.service

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.core.ports.ConsoleFacadePort
import br.com.zup.warriors.nats.core.ports.ConsoleServicePort
import javax.inject.Singleton

@Singleton
class ConsoleService(private val consoleFacade: ConsoleFacadePort): ConsoleServicePort {
    override fun cadastraConsole(console: Console) {
        consoleFacade.cadastraConsole(ConsoleConverter.consoleToConsoleBroker(console))
    }

    override fun atualizaConsole(console: Console) {
        consoleFacade.atualizaConsole(ConsoleConverter.consoleToConsoleBroker(console))
    }

    override fun deletaConsole(console: Console) {
        consoleFacade.deletaConsole(ConsoleConverter.consoleToConsoleBroker(console))
    }
}