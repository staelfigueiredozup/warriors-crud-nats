package br.com.zup.warriors.nats.controller

import br.com.zup.warriors.nats.entrypoint.dto.ConsoleRequest
import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.entrypoint.controller.ConsolesController
import br.com.zup.warriors.nats.infrastructure.service.NatsService
import br.com.zup.warriors.nats.core.ports.InformacoesConsoleServicePort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
internal class ConsolesControllerTest: AnnotationSpec() {

    val natsService = mockk<NatsService>()
    val infoConsolesService = mockk<InformacoesConsoleServicePort>()
    val controller = ConsolesController(natsService, infoConsolesService)

    lateinit var id: String
    lateinit var consoleRequest: ConsoleRequest
    lateinit var dadosRequest: DadosRequest

    @BeforeEach
    fun setUp() {
        id = UUID.randomUUID().toString()
        consoleRequest = ConsoleRequest(nome = "consoleA", marca = "marcaA", dataLancamento = null)
        dadosRequest = DadosRequest(nome = "consoleB", marca = "marcaB")
    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de cadastro para o nats`() {
        //cenário
        every { controller.cadastraConsole(any()) } answers { Unit }

        //ação
        val result = controller.cadastraConsole(consoleRequest)
        val klass = infoConsolesService.toInformacoesConsoleRequest(consoleRequest)

        //validação
        result shouldBe Unit
        klass.javaClass shouldBe InformacoesConsole::class.java
    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de atualização para o nats`() {
        //cenário
        every { controller.atualizaConsole(any(),any()) } answers { Unit }

        //ação
        val result = controller.atualizaConsole(id, dadosRequest)
        val klass = infoConsolesService.toInformacoesConsoleRequest(id, dadosRequest)

        //validação
        result shouldBe Unit
        klass.javaClass shouldBe InformacoesConsole::class.java
    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de exclusão para o nats`() {
        //cenário
        every { controller.deletaConsole(any()) } answers { Unit }

        //ação
        val result = controller.deletaConsole(id)
        val klass = infoConsolesService.toInformacoesConsoleRequest(id)

        //validação
        result shouldBe Unit
        klass.javaClass shouldBe InformacoesConsole::class.java
    }

}