package br.com.zup.warriors.nats.infrastructure.client

import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface ConsoleClient {

    @Subject("cadastro-console")
    fun send(informacoesEventsDto: InformacoesEventsDto)

}