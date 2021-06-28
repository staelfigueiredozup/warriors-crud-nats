package br.com.zup.warriors.nats.entrypoint.dto

import java.time.LocalDate

data class DadosRequest(
    val nome: String = "",
    val marca: String = "",
    val dataLancamento: LocalDate? = null
)