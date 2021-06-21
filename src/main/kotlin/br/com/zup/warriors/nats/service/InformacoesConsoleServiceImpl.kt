package br.com.zup.warriors.nats.service

import br.com.zup.warriors.nats.dto.InformacoesConsoleRequest
import br.com.zup.warriors.nats.dto.ConsoleRequest
import br.com.zup.warriors.nats.dto.DadosRequest
import javax.inject.Singleton

@Singleton
class InformacoesConsoleServiceImpl: InformacoesConsoleService {

    override fun toInformacoesConsoleRequest(consoleRequest: ConsoleRequest): InformacoesConsoleRequest {
        return InformacoesConsoleRequest(
            nome = consoleRequest.nome,
            marca = consoleRequest.marca,
            dataLancamento = consoleRequest.dataLancamento
        )
    }

    override fun toInformacoesConsoleRequest(id: String, dadosRequest: DadosRequest): InformacoesConsoleRequest{
        return InformacoesConsoleRequest(
            nome = dadosRequest.nome,
            marca = dadosRequest.marca,
            dataLancamento = dadosRequest.dataLancamento,
            id = id
        )
    }

    override fun toInformacoesConsoleRequest(id: String): InformacoesConsoleRequest {
        return InformacoesConsoleRequest(
            id = id
        )
    }
}