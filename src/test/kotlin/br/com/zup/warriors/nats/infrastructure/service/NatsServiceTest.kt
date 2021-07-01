package br.com.zup.warriors.nats.infrastructure.service

import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import br.com.zup.warriors.nats.infrastructure.client.ConsoleClient
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDate
import java.util.*

@MicronautTest
class NatsServiceTest : AnnotationSpec() {

    val consoleClient = mockk<ConsoleClient>()
    val natsService = NatsServiceImpl(consoleClient)

    lateinit var consoleBroker: ConsoleBroker
    lateinit var informacoesEventsDto: InformacoesEventsDto

    companion object{
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleBroker = ConsoleBroker(
            nome = "nomeA",
            marca = "marcaA",
            id = id,
            dataLancamento = LocalDate.now()
        )
        informacoesEventsDto = InformacoesEventsDto(
            event = ConsoleEvents.CADASTRA_CONSOLE,
            consoleBroker = consoleBroker
        )
    }

    @Test
    fun `deve transformar os dados em EventsInformationDto e enviar para o client`(){
        //cenário
        every { natsService.send(informacoesEventsDto) } answers { Unit }

        //ação
        val result = natsService.send(informacoesEventsDto)

        //validação
        result shouldBe Unit
    }

}