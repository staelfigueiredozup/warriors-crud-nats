package br.com.zup.warriors.nats.core.mapper

import br.com.zup.warriors.nats.core.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.core.model.model.InformacoesEvents
import br.com.zup.warriors.nats.infrastructure.dto.InformacoesEventsDto

class EventsConverter {

    companion object {

        fun consoleEventsToInformacoesEvents(
            events: ConsoleEvents,
            consoleRequest: InformacoesConsole
        ): InformacoesEvents {
            return InformacoesEvents(
                events,
                consoleRequest.nome,
                consoleRequest.marca,
                consoleRequest.id,
                consoleRequest.dataLancamento
            )
        }

        fun informacoesEventsToInformacoesEventsDto(
            infoEvents: InformacoesEvents
        ): InformacoesEventsDto {
            return InformacoesEventsDto(
                infoEvents.event,
                infoEvents.nome,
                infoEvents.marca,
                infoEvents.id,
                infoEvents.dataLancamento
            )
        }

    }

}