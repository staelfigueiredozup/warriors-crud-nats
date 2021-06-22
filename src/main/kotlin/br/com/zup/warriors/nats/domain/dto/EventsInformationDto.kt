package br.com.zup.warriors.nats.domain.dto

import br.com.zup.warriors.nats.domain.enums.ConsoleEvents
import java.time.LocalDate

data class EventsInformationDto(
    val event: ConsoleEvents,
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null,
)