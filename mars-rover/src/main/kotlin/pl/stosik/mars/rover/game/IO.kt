package pl.stosik.mars.rover.game

val ask: (String) -> String = { question -> puts(question).let(reads) }
val puts: (String) -> Unit = { str -> println(str) }
private val reads: (Unit) -> String = { readLine()!! }