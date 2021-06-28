package br.com.zup.warriors.nats.core.ports

import br.com.zup.warriors.nats.infrastructure.dto.InformacoesEventsDto
import javax.inject.Singleton

@Singleton
interface ConsoleClientPort {

    fun send(eventsInformation: InformacoesEventsDto)

}