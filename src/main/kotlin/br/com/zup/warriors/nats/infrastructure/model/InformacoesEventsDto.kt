package br.com.zup.warriors.nats.infrastructure.model

import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.inject.Singleton

@Introspected
data class InformacoesEventsDto(
    val event: ConsoleEvents,
    val consoleBroker: ConsoleBroker
)