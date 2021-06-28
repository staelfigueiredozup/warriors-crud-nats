package br.com.zup.warriors.nats.core.mapper

import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleRequest
import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest

class ConsoleConverter {

    companion object {

        fun consoleRequestToInformacoesConsole(consoleRequest: ConsoleRequest): InformacoesConsole {
            return InformacoesConsole(
                nome = consoleRequest.nome,
                marca = consoleRequest.marca,
                dataLancamento = consoleRequest.dataLancamento
            )
        }

        fun dadosRequestToInformacoesConsole(id: String, dadosRequest: DadosRequest): InformacoesConsole {
            return InformacoesConsole(
                nome = dadosRequest.nome,
                marca = dadosRequest.marca,
                dataLancamento = dadosRequest.dataLancamento,
                id = id
            )
        }

        fun idToInformacoesConsole(id: String): InformacoesConsole {
            return InformacoesConsole(
                id = id
            )
        }

    }

}