//package br.com.zup.warriors.nats.infrastructure.service
//
//import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
//import br.com.zup.warriors.nats.core.model.Console
//import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
//import br.com.zup.warriors.nats.infrastructure.client.ConsoleClient
//import io.kotest.core.spec.style.AnnotationSpec
//import io.kotest.matchers.shouldBe
//import io.micronaut.test.extensions.kotest.annotation.MicronautTest
//import io.mockk.every
//import io.mockk.mockk
//import java.time.LocalDate
//import java.util.*
//
//@MicronautTest
//class NatsServiceTest : AnnotationSpec() {
//
//    val consoleClient = mockk<ConsoleClient>()
//    val natsService = NatsServiceImpl(consoleClient)
//
//    lateinit var consoleRequest: Console
//    lateinit var eventsInformationDto: ConsoleBroker
//
//    companion object{
//        val id = UUID.randomUUID().toString()
//    }
//
//    @BeforeEach
//    fun setUp(){
//        consoleRequest = Console(
//            nome = "nomeA",
//            marca = "marcaA",
//            id = id,
//            dataLancamento = LocalDate.now()
//        )
//        eventsInformationDto = ConsoleBroker(
//            event = ConsoleEvents.CADASTRA_CONSOLE,
//            nome = "nomeA",
//            marca = "marcaA",
//            id = id,
//            dataLancamento = LocalDate.now()
//        )
//    }
//
//    @Test
//    fun `deve transformar os dados em EventsInformationDto e enviar para o client`(){
//        //cenário
//        every { natsService.send(ConsoleEvents.CADASTRA_CONSOLE, consoleRequest) } answers { Unit }
//
//        //ação
//        val result = natsService.send(ConsoleEvents.CADASTRA_CONSOLE, consoleRequest)
//
//        //validação
//        result shouldBe Unit
//    }
//
//}