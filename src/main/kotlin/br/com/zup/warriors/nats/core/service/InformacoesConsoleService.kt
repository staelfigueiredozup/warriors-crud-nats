package br.com.zup.warriors.nats.core.service

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.core.ports.InformacoesConsoleServicePort
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleRequest
import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
import javax.inject.Singleton

@Singleton
class InformacoesConsoleService: InformacoesConsoleServicePort {

    override fun toInformacoesConsoleRequest(consoleRequest: ConsoleRequest): InformacoesConsole {
        return ConsoleConverter.consoleRequestToInformacoesConsole(consoleRequest)
    }

    override fun toInformacoesConsoleRequest(id: String, dadosRequest: DadosRequest): InformacoesConsole {
        return ConsoleConverter.dadosRequestToInformacoesConsole(id, dadosRequest)
    }

    override fun toInformacoesConsoleRequest(id: String): InformacoesConsole {
        return ConsoleConverter.idToInformacoesConsole(id)
    }
}