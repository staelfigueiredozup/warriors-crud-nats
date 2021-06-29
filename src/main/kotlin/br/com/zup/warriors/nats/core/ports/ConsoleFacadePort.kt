package br.com.zup.warriors.nats.core.ports

import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import javax.inject.Singleton

@Singleton
interface ConsoleFacadePort {

    fun cadastraConsole(consoleBroker: ConsoleBroker): Console
    fun atualizaConsole(consoleBroker: ConsoleBroker): Console
    fun deletaConsole(consoleBroker: ConsoleBroker)

}