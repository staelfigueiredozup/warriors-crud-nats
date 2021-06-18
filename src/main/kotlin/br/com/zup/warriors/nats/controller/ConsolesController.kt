package br.com.zup.warriors.nats.controller

import br.com.zup.warriors.nats.dto.ConsoleRequest
import br.com.zup.warriors.nats.nats.NatsService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.LoggerFactory

@Controller("/v1/consoles")
class ConsolesController(private val natsService: NatsService) {

    @Post
    fun cadastraConsole(@Body consoleRequest: ConsoleRequest){
        val consoleResponse = consoleRequest.toConsoleResponse()
        natsService.send(consoleResponse)
    }
    
}