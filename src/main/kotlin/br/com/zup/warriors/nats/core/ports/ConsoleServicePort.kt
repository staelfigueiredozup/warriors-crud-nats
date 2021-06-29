package br.com.zup.warriors.nats.core.ports

import br.com.zup.warriors.nats.core.model.Console
import javax.inject.Singleton

@Singleton
interface ConsoleServicePort {

    fun cadastraConsole(console: Console)
    fun atualizaConsole(console: Console)
    fun deletaConsole(console: Console)

}