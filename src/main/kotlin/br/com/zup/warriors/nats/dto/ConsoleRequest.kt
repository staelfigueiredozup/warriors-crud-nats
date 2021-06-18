package br.com.zup.warriors.nats.dto

import java.time.LocalDate

data class ConsoleRequest(
    val nome: String = "",
    val marca: String = "",
    val dataLancamento: LocalDate? = null
) {

    fun toConsoleResponse(): ConsoleResponse {
        return ConsoleResponse(
            nome = nome,
            marca = marca,
            dataLancamento = dataLancamento
        )
    }

}