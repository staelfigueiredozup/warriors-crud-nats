package br.com.zup.warriors.nats.core.ports

import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleRequest
import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
import javax.inject.Singleton

@Singleton
interface InformacoesConsoleServicePort {

    fun toInformacoesConsoleRequest(consoleRequest: ConsoleRequest): InformacoesConsole
    fun toInformacoesConsoleRequest(id: String, dadosRequest: DadosRequest): InformacoesConsole
    fun toInformacoesConsoleRequest(id: String): InformacoesConsole

}