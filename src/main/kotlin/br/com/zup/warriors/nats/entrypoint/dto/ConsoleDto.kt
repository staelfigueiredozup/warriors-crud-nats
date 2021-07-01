package br.com.zup.warriors.nats.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class ConsoleDto(
    val nome: String = "",
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null
)