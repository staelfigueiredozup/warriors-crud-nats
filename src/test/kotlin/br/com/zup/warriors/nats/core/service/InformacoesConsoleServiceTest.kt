package br.com.zup.warriors.nats.core.service

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.model.InformacoesConsole
import br.com.zup.warriors.nats.entrypoint.dto.ConsoleRequest
import br.com.zup.warriors.nats.entrypoint.dto.DadosRequest
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDate
import java.util.*

@MicronautTest
class InformacoesConsoleServiceTest : AnnotationSpec(){

    val converter = mockk<ConsoleConverter.Companion>()
    val infoConsoleService = InformacoesConsoleService()

    lateinit var consoleRequest: ConsoleRequest
    lateinit var informacoesConsole: InformacoesConsole
    lateinit var dadosRequest: DadosRequest

    companion object {
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleRequest = ConsoleRequest(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now())
        informacoesConsole = InformacoesConsole(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now(), id = "")
        dadosRequest = DadosRequest(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now())
    }

    @Test
    fun `deve enviar consoleRequest para o converter e retornar InformacoesConsole`(){
        //cenário
        every { converter.consoleRequestToInformacoesConsole(any()) } answers { informacoesConsole }

        //ação
        val result = infoConsoleService.toInformacoesConsoleRequest(consoleRequest)

        //validação
        result.javaClass shouldBe InformacoesConsole::class.java
        result.nome shouldBe "consoleA"
        result.id shouldBe ""
    }

    @Test
    fun `deve enviar id e dadosRequest para o converter e retornar InformacoesConsole`(){
        //cenário
        every { converter.dadosRequestToInformacoesConsole(any(), any()) } answers { informacoesConsole }

        //ação
        val result = infoConsoleService.toInformacoesConsoleRequest(id, dadosRequest)

        //validação
        result.javaClass shouldBe InformacoesConsole::class.java
        result.nome shouldBe "consoleA"
        result.id shouldBe id
    }

    @Test
    fun `deve enviar id para o converter e retornar InformacoesConsole`(){
        //cenário
        every { converter.idToInformacoesConsole(any()) } answers { informacoesConsole }

        //ação
        val result = infoConsoleService.toInformacoesConsoleRequest(id)

        //validação
        result.javaClass shouldBe InformacoesConsole::class.java
        result.nome shouldBe ""
        result.id shouldBe id
    }

}