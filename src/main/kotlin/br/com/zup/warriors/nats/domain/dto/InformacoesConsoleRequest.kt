package br.com.zup.warriors.nats.domain.dto

import java.time.LocalDate

data class InformacoesConsoleRequest(
    val nome: String = "",
    val marca: String = "",
    var id: String = "",
    val dataLancamento: LocalDate? = null
)