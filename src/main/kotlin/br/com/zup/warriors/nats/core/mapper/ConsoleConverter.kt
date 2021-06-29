package br.com.zup.warriors.nats.core.mapper

import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleDto
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker

class ConsoleConverter {

    companion object {

        fun consoleBrokerToConsole(consoleBroker: ConsoleBroker) =
            Console(consoleBroker.nome, consoleBroker.marca, consoleBroker.id, consoleBroker.dataLancamento)

        fun consoleDtoToConsole(consoleDto: ConsoleDto) =
            Console(consoleDto.nome, consoleDto.marca, consoleDto.id, consoleDto.dataLancamento)

        fun consoleToConsoleBroker(console: Console) =
            ConsoleBroker(console.nome, console.marca, console.id, console.dataLancamento)

    }

}