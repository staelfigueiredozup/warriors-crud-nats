package br.com.zup.warriors.nats.infrastructure.service

import br.com.zup.warriors.nats.core.mapper.EventsConverter
import br.com.zup.warriors.nats.core.mapper.EventsConverter.Companion.consoleEventsToInformacoesEvents
import br.com.zup.warriors.nats.core.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.core.ports.ConsoleClientPort
import br.com.zup.warriors.nats.core.ports.NatsServicePort
import javax.inject.Singleton

@Singleton
class NatsService(private val consolePublisher : ConsoleClientPort): NatsServicePort {

    override fun send(events: ConsoleEvents, consoleRequest: InformacoesConsole){
        val eventsInformation = consoleEventsToInformacoesEvents(events, consoleRequest)
        consolePublisher.send(EventsConverter.informacoesEventsToInformacoesEventsDto(eventsInformation))
    }

}