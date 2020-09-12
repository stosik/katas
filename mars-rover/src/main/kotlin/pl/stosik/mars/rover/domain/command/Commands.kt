package pl.stosik.mars.rover.domain.command

import pl.stosik.mars.rover.domain.rover.Rover

sealed class Command {
    abstract fun execute(): Rover
}

data class EmptyCommand(val rover: Rover) : Command() {
    override fun execute(): Rover = rover
}

data class MoveForwardCommand(val rover: Rover) : Command() {
    override fun execute(): Rover = rover.moveForward()
}

data class MoveBackwardCommand(val rover: Rover) : Command() {
    override fun execute(): Rover = rover.moveBackward()
}

data class TurnLeftCommand(val rover: Rover) : Command() {
    override fun execute(): Rover = rover.turnLeft()
}

data class TurnRightCommand(val rover: Rover) : Command() {
    override fun execute(): Rover = rover.turnRight()
}
