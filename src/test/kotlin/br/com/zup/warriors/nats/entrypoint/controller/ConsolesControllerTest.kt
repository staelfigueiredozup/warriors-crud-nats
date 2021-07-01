package br.com.zup.warriors.nats.entrypoint.controller

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.core.ports.ConsoleServicePort
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleDto
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.mockk.every
import io.mockk.mockk
import java.util.*

class ConsolesControllerTest : AnnotationSpec() {

    val infoConsolesService = mockk<ConsoleServicePort>()
    val controller = ConsolesController(infoConsolesService)
    val consoleConverter = mockk<ConsoleConverter.Companion>()

    lateinit var id: String
    lateinit var consoleDto: ConsoleDto
    lateinit var console: Console

    @BeforeEach
    fun setUp() {
        id = UUID.randomUUID().toString()
        consoleDto = ConsoleDto(nome = "consoleA", marca = "marcaA", dataLancamento = null)
        console = Console(nome = "consoleB", marca = "marcaB", dataLancamento = null)
    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de cadastro para o nats`() {
        //cenário
        every { controller.cadastraConsole(consoleDto) } answers { HttpResponse.accepted() }
        every { consoleConverter.consoleDtoToConsole(consoleDto) } answers { console }

        //ação
        val result = controller.cadastraConsole(consoleDto)

        //validação
        result.status.code shouldBe HttpStatus.ACCEPTED.code

    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de atualização para o nats`() {
        //cenário
        every { controller.atualizaConsole(id ,consoleDto) } answers { HttpResponse.accepted() }
        every { consoleConverter.consoleDtoToConsole(consoleDto) } answers { console }

        //ação
        val result = controller.atualizaConsole(id, consoleDto)

        //validação
        result.status.code shouldBe HttpStatus.ACCEPTED.code
    }

    @Test
    fun `deve  transformar dados em InformacoesConsoleRequest e enviar mensagem de exclusão para o nats`() {
        //cenário
        every { controller.deletaConsole(id) } answers { HttpResponse.accepted() }
        every { consoleConverter.consoleDtoToConsole(consoleDto) } answers { console }

        //ação
        val result = controller.deletaConsole(id)

        //validação
        result.status.code shouldBe HttpStatus.ACCEPTED.code
    }

}