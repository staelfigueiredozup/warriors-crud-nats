//package br.com.zup.warriors.nats.core.service
//
//import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
//import br.com.zup.warriors.nats.core.model.Console
//import br.com.zup.warriors.nats.entrypoint.dto.ConsoleDto
//import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
//import io.kotest.core.spec.style.AnnotationSpec
//import io.kotest.matchers.shouldBe
//import io.micronaut.test.extensions.kotest.annotation.MicronautTest
//import io.mockk.every
//import io.mockk.mockk
//import java.time.LocalDate
//import java.util.*
//
//@MicronautTest
//class InformacoesConsoleServiceTest : AnnotationSpec(){
//
//    val converter = mockk<ConsoleConverter.Companion>()
//    val infoConsoleService = ConsoleService()
//
//    lateinit var consoleRequest: ConsoleDto
//    lateinit var informacoesConsole: Console
//    lateinit var dadosRequest: DadosRequest
//
//    companion object {
//        val id = UUID.randomUUID().toString()
//    }
//
//    @BeforeEach
//    fun setUp(){
//        consoleRequest = ConsoleDto(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now())
//        informacoesConsole = Console(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now(), id = "")
//        dadosRequest = DadosRequest(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now())
//    }
//
//    @Test
//    fun `deve enviar consoleRequest para o converter e retornar InformacoesConsole`(){
//        //cenário
//        every { converter.consoleRequestToInformacoesConsole(any()) } answers { informacoesConsole }
//
//        //ação
//        val result = infoConsoleService.toInformacoesConsoleRequest(consoleRequest)
//
//        //validação
//        result.javaClass shouldBe Console::class.java
//        result.nome shouldBe "consoleA"
//        result.id shouldBe ""
//    }
//
//    @Test
//    fun `deve enviar id e dadosRequest para o converter e retornar InformacoesConsole`(){
//        //cenário
//        every { converter.dadosRequestToInformacoesConsole(any(), any()) } answers { informacoesConsole }
//
//        //ação
//        val result = infoConsoleService.toInformacoesConsoleRequest(id, dadosRequest)
//
//        //validação
//        result.javaClass shouldBe Console::class.java
//        result.nome shouldBe "consoleA"
//        result.id shouldBe id
//    }
//
//    @Test
//    fun `deve enviar id para o converter e retornar InformacoesConsole`(){
//        //cenário
//        every { converter.idToInformacoesConsole(any()) } answers { informacoesConsole }
//
//        //ação
//        val result = infoConsoleService.toInformacoesConsoleRequest(id)
//
//        //validação
//        result.javaClass shouldBe Console::class.java
//        result.nome shouldBe ""
//        result.id shouldBe id
//    }
//
//}