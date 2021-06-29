package br.com.zup.warriors.nats.infrastructure.service

import br.com.zup.warriors.nats.infrastructure.client.ConsoleClient
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import javax.inject.Singleton

@Singleton
class NatsServiceImpl(private val consoleClient : ConsoleClient): NatsService {

    override fun send(informacoesEventsDto: InformacoesEventsDto){
        consoleClient.send(informacoesEventsDto)
    }

}