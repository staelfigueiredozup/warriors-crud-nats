package br.com.zup.warriors.nats.controller

import br.com.zup.warriors.nats.domain.dto.ConsoleRequest
import br.com.zup.warriors.nats.domain.dto.DadosRequest
import br.com.zup.warriors.nats.domain.enums.ConsoleEvents
import br.com.zup.warriors.nats.nats.NatsService
import br.com.zup.warriors.nats.service.InformacoesConsoleService
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/v1/consoles")
class ConsolesController(
    private val natsService: NatsService,
    private val infoConsoleService: InformacoesConsoleService
    ) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    fun cadastraConsole(@Body @Valid consoleRequest: ConsoleRequest){
        logger.info("Recebidas informações de console para cadastro")
        val informacoesConsoleRequest = infoConsoleService.toInformacoesConsoleRequest(consoleRequest)
        natsService.send(ConsoleEvents.CADASTRA_CONSOLE, informacoesConsoleRequest)
    }

    @Put("/{id}")
    fun atualizaConsole(@PathVariable id: String, dadosRequest: DadosRequest){
        logger.info("Recebidas informações de console para atualização")
        val informacoesConsoleRequest = infoConsoleService.toInformacoesConsoleRequest(id, dadosRequest)
        natsService.send(ConsoleEvents.ALTERA_CONSOLE, informacoesConsoleRequest)
    }

    @Delete("/{id}")
    fun deletaConsole(@PathVariable id: String){
        logger.info("Recebidas informações de console para remoção")
        val informacoesConsoleRequest = infoConsoleService.toInformacoesConsoleRequest(id)
        natsService.send(ConsoleEvents.DELETA_CONSOLE, informacoesConsoleRequest)
    }

}