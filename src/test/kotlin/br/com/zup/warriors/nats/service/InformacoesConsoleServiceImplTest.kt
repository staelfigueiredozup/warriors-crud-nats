package br.com.zup.warriors.nats.service

import br.com.zup.warriors.nats.domain.dto.ConsoleRequest
import br.com.zup.warriors.nats.domain.dto.DadosRequest
import br.com.zup.warriors.nats.domain.dto.InformacoesConsoleRequest
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import java.util.*

@MicronautTest
class InformacoesConsoleServiceImplTest : AnnotationSpec() {

    val informacoesConsoleService = InformacoesConsoleServiceImpl()

    lateinit var consoleRequest: ConsoleRequest
    lateinit var dadosRequest: DadosRequest
    lateinit var infoConsoleRequest: InformacoesConsoleRequest

    companion object {
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleRequest = ConsoleRequest(nome = "consoleA", marca = "marcaA", dataLancamento = null)
        dadosRequest = DadosRequest(nome = "consoleA", marca = "marcaA", dataLancamento = null)
        infoConsoleRequest = InformacoesConsoleRequest(nome = "consoleA", marca = "marcaA", dataLancamento = null)
    }

    @Test
    fun `deve transformar consoleRequest em InformacoesConsoleRequest`(){
        //cenário

        //ação
        val result = informacoesConsoleService.toInformacoesConsoleRequest(consoleRequest)

        //validação
        result.id shouldBe ""
        result.nome shouldBe "consoleA"
        result.marca shouldBe "marcaA"
    }

    @Test
    fun `deve transformar id e dadosRequest em InformacoesConsoleRequest`(){
        //cenário

        //ação
        val result = informacoesConsoleService.toInformacoesConsoleRequest(id, dadosRequest)

        //validação
        result.id shouldBe id
        result.nome shouldBe "consoleA"
        result.marca shouldBe "marcaA"
    }

    @Test
    fun `deve transformar id em InformacoesConsoleRequest`(){
        //cenário

        //ação
        val result = informacoesConsoleService.toInformacoesConsoleRequest(id)

        //validação
        result.id shouldBe id
        result.nome shouldBe ""
        result.marca shouldBe ""
    }

}