package br.com.zup.warriors.nats.nats

import br.com.zup.warriors.nats.domain.dto.InformacoesConsoleRequest
import br.com.zup.warriors.nats.domain.dto.EventsInformationDto
import br.com.zup.warriors.nats.domain.enums.ConsoleEvents
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