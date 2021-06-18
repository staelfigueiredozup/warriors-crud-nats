package br.com.zup.warriors.nats.nats

import br.com.zup.warriors.nats.dto.ConsoleResponse
import javax.inject.Singleton

@Singleton
class NatsService(private val consolePublisher : ConsoleClient) {

    fun send(consoleResponse: ConsoleResponse){
        consolePublisher.send(consoleResponse)
    }

}