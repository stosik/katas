package pl.stosik.mars.rover.domain.command

import pl.stosik.mars.rover.domain.rover.Rover

internal class CommandFactory(rover: Rover) {
    private val commands: Map<String, Command> by lazy { instantiateFactory(rover) }

    fun commandFrom(command: String) = commands[command]

    private fun instantiateFactory(rover: Rover) = mapOf(
        MOVE_FORWARD to MoveForwardCommand(rover),
        MOVE_BACKWARD to MoveBackwardCommand(rover),
        TURN_LEFT to TurnLeftCommand(rover),
        TURN_RIGHT to TurnRightCommand(rover),
        EMPTY_COMMAND to EmptyCommand(rover)
    )

    companion object {
        private const val MOVE_FORWARD = "F"
        private const val MOVE_BACKWARD = "B"
        private const val TURN_LEFT = "L"
        private const val TURN_RIGHT = "R"
        private const val EMPTY_COMMAND = ""
    }
}