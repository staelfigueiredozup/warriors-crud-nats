package br.com.zup.warriors.nats.infrastructure.facade

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.core.ports.ConsoleFacadePort
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.infrastructure.service.NatsService
import javax.inject.Singleton

@Singleton
class ConsoleFacadeImpl(private val natsService: NatsService): ConsoleFacadePort {
    override fun cadastraConsole(consoleBroker: ConsoleBroker): Console {
        val events = InformacoesEventsDto(ConsoleEvents.CADASTRA_CONSOLE, consoleBroker)
        natsService.send(events)
        return ConsoleConverter.consoleBrokerToConsole(events.consoleBroker)
    }

    override fun atualizaConsole(consoleBroker: ConsoleBroker): Console {
        val events = InformacoesEventsDto(ConsoleEvents.ALTERA_CONSOLE, consoleBroker)
        natsService.send(events)
        return ConsoleConverter.consoleBrokerToConsole(events.consoleBroker)
    }

    override fun deletaConsole(consoleBroker: ConsoleBroker) {
        val events = InformacoesEventsDto(ConsoleEvents.DELETA_CONSOLE, consoleBroker)
        natsService.send(events)
    }
}