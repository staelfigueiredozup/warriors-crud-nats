package br.com.zup.warriors.nats.entrypoint.controller

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.ports.ConsoleServicePort
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/v1/consoles")
class ConsolesController(
    private val consoleService: ConsoleServicePort,
    ) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    fun cadastraConsole(@Body @Valid console: ConsoleDto): HttpResponse<Any> {
        logger.info("Recebidas informações de console para cadastro")
        consoleService.cadastraConsole(ConsoleConverter.consoleDtoToConsole(console))
        return HttpResponse.accepted()
    }

    @Put("/{id}")
    fun atualizaConsole(@PathVariable id: String, console: ConsoleDto): HttpResponse<Any>{
        logger.info("Recebidas informações de console para atualização")
        val consoleDto = ConsoleDto(console.nome, console.marca, id, console.dataLancamento)
        consoleService.atualizaConsole(ConsoleConverter.consoleDtoToConsole(consoleDto))
        return HttpResponse.accepted()
    }

    @Delete("/{id}")
    fun deletaConsole(@PathVariable id: String): HttpResponse<Any> {
        logger.info("Recebidas informações de console para remoção")
        val consoleDto = ConsoleDto("","",id,null)
        consoleService.deletaConsole(ConsoleConverter.consoleDtoToConsole(consoleDto))
        return HttpResponse.accepted()
    }

}