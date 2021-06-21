package br.com.zup.warriors.nats.service

import br.com.zup.warriors.nats.dto.ConsoleRequest
import br.com.zup.warriors.nats.dto.DadosRequest
import br.com.zup.warriors.nats.dto.InformacoesConsoleRequest

interface InformacoesConsoleService {

    fun toInformacoesConsoleRequest(consoleRequest: ConsoleRequest): InformacoesConsoleRequest
    fun toInformacoesConsoleRequest(id: String, dadosRequest: DadosRequest): InformacoesConsoleRequest
    fun toInformacoesConsoleRequest(id: String): InformacoesConsoleRequest

}