package br.com.zup.warriors.nats.nats

import br.com.zup.warriors.nats.domain.dto.EventsInformationDto
import br.com.zup.warriors.nats.domain.dto.InformacoesConsoleRequest
import br.com.zup.warriors.nats.domain.enums.ConsoleEvents
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDate
import java.util.*

@MicronautTest
class NatsServiceTest : AnnotationSpec() {

    val consoleClient = mockk<ConsoleClient>()
    val natsService = NatsService(consoleClient)

    lateinit var consoleRequest: InformacoesConsoleRequest
    lateinit var eventsInformationDto: EventsInformationDto

    companion object{
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleRequest = InformacoesConsoleRequest(
            nome = "nomeA",
            marca = "marcaA",
            id = id,
            dataLancamento = LocalDate.now()
        )
        eventsInformationDto = EventsInformationDto(
            event = ConsoleEvents.CADASTRA_CONSOLE,
            nome = "nomeA",
            marca = "marcaA",
            id = id,
            dataLancamento = LocalDate.now()
        )
    }

    @Test
    fun `deve transformar os dados em EventsInformationDto e enviar para o client`(){
        //cenário
        every { natsService.send(ConsoleEvents.CADASTRA_CONSOLE, consoleRequest) } answers { Unit }

        //ação
        val result = natsService.send(ConsoleEvents.CADASTRA_CONSOLE, consoleRequest)

        //validação
        result shouldBe Unit
    }

}