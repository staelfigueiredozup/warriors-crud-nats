package br.com.zup.warriors.nats.core.model.model

import br.com.zup.warriors.nats.core.model.enums.ConsoleEvents
import java.time.LocalDate

data class InformacoesEvents(
    val event: ConsoleEvents,
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null,
)