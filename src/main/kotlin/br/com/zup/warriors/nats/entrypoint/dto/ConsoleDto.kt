package br.com.zup.warriors.nats.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank

@Introspected
data class ConsoleDto(
    @field:NotBlank
    val nome: String = "",
    @field:NotBlank
    val marca: String = "",
    val id: String = "",
    val dataLancamento: LocalDate? = null
)