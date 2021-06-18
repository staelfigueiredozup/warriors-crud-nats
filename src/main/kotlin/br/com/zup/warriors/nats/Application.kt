package br.com.zup.warriors.nats

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.zup.warriors.nats")
		.start()
}

