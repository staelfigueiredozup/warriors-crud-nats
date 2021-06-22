package br.com.zup.warriors.nats.nats

import br.com.zup.warriors.nats.domain.dto.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface ConsoleClient {

    @Subject("cadastro-console")
    fun send(eventsInformation: EventsInformationDto)

}