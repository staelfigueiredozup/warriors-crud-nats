//package br.com.zup.warriors.nats.entrypoint.controller
//
//import br.com.zup.warriors.nats.core.model.Console
//import br.com.zup.warriors.nats.core.ports.ConsoleServicePort
//import br.com.zup.warriors.nats.entrypoint.dto.ConsoleDto
//import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
//import br.com.zup.warriors.nats.infrastructure.service.NatsServiceImpl
//import io.kotest.core.spec.style.AnnotationSpec
//import io.kotest.matchers.shouldBe
//import io.mockk.every
//import io.mockk.mockk
//import java.util.*
//
//class ConsolesControllerTest : AnnotationSpec() {
//
//    val natsService = mockk<NatsServiceImpl>()
//    val infoConsolesService = mockk<ConsoleServicePort>()
//    val controller = ConsolesController(natsService, infoConsolesService)
//
//    lateinit var id: String
//    lateinit var consoleRequest: ConsoleDto
//    lateinit var dadosRequest: DadosRequest
//
//    @AnnotationSpec.BeforeEach
//    fun setUp() {
//        id = UUID.randomUUID().toString()
//        consoleRequest = ConsoleDto(nome = "consoleA", marca = "marcaA", dataLancamento = null)
//        dadosRequest = DadosRequest(nome = "consoleB", marca = "marcaB")
//    }
//
//    @AnnotationSpec.Test
//    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de cadastro para o nats`() {
//        //cenário
//        every { controller.cadastraConsole(any()) } answers { Unit }
//
//        //ação
//        val result = controller.cadastraConsole(consoleRequest)
//        val klass = infoConsolesService.toInformacoesConsoleRequest(consoleRequest)
//
//        //validação
//        result shouldBe Unit
//        klass.javaClass shouldBe Console::class.java
//    }
//
//    @AnnotationSpec.Test
//    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de atualização para o nats`() {
//        //cenário
//        every { controller.atualizaConsole(any(),any()) } answers { Unit }
//
//        //ação
//        val result = controller.atualizaConsole(id, dadosRequest)
//        val klass = infoConsolesService.toInformacoesConsoleRequest(id, dadosRequest)
//
//        //validação
//        result shouldBe Unit
//        klass.javaClass shouldBe Console::class.java
//    }
//
//    @AnnotationSpec.Test
//    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de exclusão para o nats`() {
//        //cenário
//        every { controller.deletaConsole(any()) } answers { Unit }
//
//        //ação
//        val result = controller.deletaConsole(id)
//        val klass = infoConsolesService.toInformacoesConsoleRequest(id)
//
//        //validação
//        result shouldBe Unit
//        klass.javaClass shouldBe Console::class.java
//    }
//
//}