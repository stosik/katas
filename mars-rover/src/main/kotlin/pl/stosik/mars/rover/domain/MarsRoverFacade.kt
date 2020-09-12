package pl.stosik.mars.rover.domain

import pl.stosik.mars.rover.domain.command.CommandFactory
import pl.stosik.mars.rover.domain.rover.Rover

const val CHARACTERS_DELIMITER = ""

internal class MarsRoverFacade {

    fun execute(rover: Rover, input: String) = handleCommands(rover, commandsFrom(input))

    private fun handleCommands(rover: Rover, commands: Array<String>) = commands
        .asSequence()
        .fold(rover) { newRover, nextCommand -> handleCommand(newRover, nextCommand)}

    private fun handleCommand(rover: Rover, command: String) = CommandFactory(rover).commandFrom(command)!!.execute()

    private fun commandsFrom(input: String) = input.split(CHARACTERS_DELIMITER.toRegex()).toTypedArray()
}