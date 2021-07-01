package br.com.zup.warriors.nats.infrastructure.facade

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import br.com.zup.warriors.nats.infrastructure.model.InformacoesEventsDto
import br.com.zup.warriors.nats.infrastructure.model.enums.ConsoleEvents
import br.com.zup.warriors.nats.infrastructure.service.NatsService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class ConsoleFacadeImplTest : AnnotationSpec() {

    val natsService = mockk<NatsService>()
    val consoleFacadeImpl = ConsoleFacadeImpl(natsService)
    val consoleConverter = mockk<ConsoleConverter.Companion>()

    lateinit var consoleBroker: ConsoleBroker
    lateinit var console: Console

    companion object {
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleBroker = ConsoleBroker("consoleA", "marcaA", id, null)
        console = Console("consoleA", "marcaA", id, null)
    }

    @Test
    fun `deve enviar o evento de cadastro para o nats e retornar um console`(){
        //cenário
        every { natsService.send(any()) } answers { Unit }
        every { consoleConverter.consoleBrokerToConsole(consoleBroker) } answers { console }

        //ação
        val result = consoleFacadeImpl.cadastraConsole(consoleBroker)

        //validação
        result.javaClass shouldBe Console::class.java
        result.id shouldBe id
    }

    @Test
    fun `deve enviar o evento de alteração para o nats e retornar um console`(){
        //cenário
        every { natsService.send(any()) } answers { Unit }

        //ação
        val result = consoleFacadeImpl.atualizaConsole(consoleBroker)

        //validação
        result.javaClass shouldBe Console::class.java
        result.id shouldBe id
    }

    @Test
    fun `deve enviar o evento de remoção para o nats`(){
        //cenário
        every { natsService.send(any()) } answers { Unit }

        //ação
        val result = consoleFacadeImpl.deletaConsole(consoleBroker)

        //validação
        result shouldBe Unit
    }

}