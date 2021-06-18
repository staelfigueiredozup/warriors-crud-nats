package br.com.zup.warriors.nats.dto

import java.time.LocalDate

data class ConsoleResponse(
    val nome: String = "",
    val marca: String = "",
    val dataLancamento: LocalDate? = null
)