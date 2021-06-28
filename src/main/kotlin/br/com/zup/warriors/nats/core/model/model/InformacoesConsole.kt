package br.com.zup.warriors.nats.core.model.model

import java.time.LocalDate

data class InformacoesConsole(
    val nome: String = "",
    val marca: String = "",
    var id: String = "",
    val dataLancamento: LocalDate? = null
)