package br.com.zup.warriors.nats.infrastructure.model

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate

@Introspected
data class ConsoleBroker(
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null,
)