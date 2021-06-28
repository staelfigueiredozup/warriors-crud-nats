package br.com.zup.warriors.nats.infrastructure.dto

import br.com.zup.warriors.nats.core.model.enums.ConsoleEvents
import java.time.LocalDate

data class InformacoesEventsDto(
    val event: ConsoleEvents,
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null,
)