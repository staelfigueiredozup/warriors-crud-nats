package br.com.zup.warriors.nats.infrastructure.client

import br.com.zup.warriors.nats.core.ports.ConsoleClientPort
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface ConsoleClient: ConsoleClientPort {

    @Subject("cadastro-console")
    override fun send(eventsInformation: InformacoesEventsDto)

}