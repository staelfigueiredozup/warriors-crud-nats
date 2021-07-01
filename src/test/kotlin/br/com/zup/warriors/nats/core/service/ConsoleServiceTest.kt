package br.com.zup.warriors.nats.core.service

import br.com.zup.warriors.nats.core.mapper.ConsoleConverter
import br.com.zup.warriors.nats.core.model.Console
import br.com.zup.warriors.nats.core.ports.ConsoleFacadePort
import br.com.zup.warriors.nats.infrastructure.model.ConsoleBroker
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDate
import java.util.*

@MicronautTest
class ConsoleServiceTest : AnnotationSpec(){

    val converter = mockk<ConsoleConverter.Companion>()
    val consoleFacade = mockk<ConsoleFacadePort>()
    val consoleService = ConsoleService(consoleFacade)

    lateinit var consoleBroker: ConsoleBroker
    lateinit var console: Console

    companion object {
        val id = UUID.randomUUID().toString()
    }

    @BeforeEach
    fun setUp(){
        consoleBroker = ConsoleBroker(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now(), id = "")
        console = Console(nome = "consoleA", marca = "marcaA", dataLancamento = LocalDate.now(), id = "")
    }

    @Test
    fun `deve enviar console para o converter e retornar ConsoleBroker`(){
        //cenário
        every { converter.consoleToConsoleBroker(console) } answers { consoleBroker }
        every { consoleFacade.cadastraConsole(consoleBroker) } answers { console }

        //ação
        val result = consoleService.cadastraConsole(console)

        //validação
        result shouldBe Unit
    }

    @Test
    fun `deve enviar console para o converter e depois para cadastro`(){
        //cenário
        every { converter.consoleToConsoleBroker(console) } answers { consoleBroker }
        every { consoleFacade.atualizaConsole(consoleBroker) } answers { console }

        //ação
        val result = consoleService.atualizaConsole(console)

        //validação
        result shouldBe Unit
    }

    @Test
    fun `deve enviar console para o converter e depois para atualização`(){
        //cenário
        every { converter.consoleToConsoleBroker(console) } answers { consoleBroker }
        every { consoleFacade.deletaConsole(consoleBroker) } answers { Unit }

        //ação
        val result = consoleService.deletaConsole(console)

        //validação
        result shouldBe Unit
    }

}