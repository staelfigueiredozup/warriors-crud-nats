package br.com.zup.warriors.nats.infrastructure.service

import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import javax.inject.Singleton

@Singleton
interface NatsService {

    fun send(informacoesEventsDto: InformacoesEventsDto)

}