package br.com.zup.warriors.nats.nats

import br.com.zup.warriors.nats.dto.InformacoesConsoleRequest
import br.com.zup.warriors.nats.dto.EventsInformationDto
import br.com.zup.warriors.nats.event.ConsoleEvents
import javax.inject.Singleton

@Singleton
class NatsService(private val consolePublisher : ConsoleClient) {

    fun send(events: ConsoleEvents, consoleRequest: InformacoesConsoleRequest){
        val eventsInformation = EventsInformationDto(
            events,
            consoleRequest.nome,
            consoleRequest.marca,
            consoleRequest.id,
            consoleRequest.dataLancamento
        )
        consolePublisher.send(eventsInformation)
    }

}