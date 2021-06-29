package br.com.zup.warriors.nats.core.model

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate

@Introspected
data class Console(
    val nome: String = "",
    val marca: String = "",
    var id: String = "",
    val dataLancamento: LocalDate? = null
)