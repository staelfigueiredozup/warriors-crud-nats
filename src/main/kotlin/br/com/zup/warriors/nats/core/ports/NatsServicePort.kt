package br.com.zup.warriors.nats.core.ports

import br.com.zup.warriors.nats.core.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import javax.inject.Singleton

@Singleton
interface NatsServicePort {

    fun send(events: ConsoleEvents, consoleRequest: InformacoesConsole)

}