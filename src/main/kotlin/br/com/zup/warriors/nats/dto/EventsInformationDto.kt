package br.com.zup.warriors.nats.dto

import br.com.zup.warriors.nats.event.ConsoleEvents
import java.time.LocalDate

class EventsInformationDto(
    val event: ConsoleEvents,
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null,
)