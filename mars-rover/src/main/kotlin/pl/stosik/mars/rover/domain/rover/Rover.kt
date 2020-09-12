package pl.stosik.mars.rover.domain.rover

import pl.stosik.mars.rover.domain.value.*

const val REPORT_FORMAT = "Obstacle encountered at x:%d y:%d, keeping position"

sealed class Rover(private val coordinates: Coordinates, private val mars: Mars) {
    abstract fun turnLeft(): Rover
    abstract fun turnRight(): Rover
    abstract fun moveForward(): Rover
    abstract fun moveBackward(): Rover
    abstract fun name(): String

    fun detectCollision(newCoordinates: Coordinates) =
        if (mars.obstacles.contains(newCoordinates)) {
            reportObstacle()
            coordinates
        }
        else
            newCoordinates

    fun position() = "${coordinates.x} ${coordinates.y} ${name()}"
    private fun reportObstacle() = String.format(REPORT_FORMAT, coordinates.x, coordinates.y)
}

data class RoverHeadingNorth(val coordinates: Coordinates, val mars: Mars): Rover(coordinates, mars) {
    override fun moveForward(): Rover = this
        .let { mars spherePlusY coordinates }
        .let { detectCollision(coordinates.newY(y = it)) }
        .let { RoverHeadingNorth(it, mars) }

    override fun moveBackward(): Rover = this
        .let { mars sphereMinusY coordinates }
        .let { detectCollision(coordinates.newY(y = it)) }
        .let { RoverHeadingNorth(it, mars) }

    override fun turnLeft(): Rover = RoverHeadingWest(coordinates, mars)
    override fun turnRight(): Rover = RoverHeadingEast(coordinates, mars)
    override fun name(): String = "N"
}

data class RoverHeadingSouth(val coordinates: Coordinates, val mars: Mars): Rover(coordinates, mars) {
    override fun moveForward(): Rover = this
        .let { mars sphereMinusY coordinates }
        .let { detectCollision(coordinates.newY(y = it)) }
        .let { RoverHeadingSouth(it, mars) }

    override fun moveBackward(): Rover =  this
        .let { mars spherePlusY coordinates }
        .let { detectCollision(coordinates.newY(y = it)) }
        .let { RoverHeadingSouth(it, mars) }

    override fun turnLeft(): Rover = RoverHeadingEast(coordinates, mars)
    override fun turnRight(): Rover = RoverHeadingWest(coordinates, mars)
    override fun name(): String = "S"
}

data class RoverHeadingEast(val coordinates: Coordinates, val mars: Mars): Rover(coordinates, mars) {
    override fun moveForward(): Rover = this
        .let { mars spherePlusX coordinates }
        .let { detectCollision(coordinates.newX(x = it)) }
        .let { RoverHeadingEast(it, mars) }

    override fun moveBackward(): Rover = this
        .let { mars sphereMinusX coordinates }
        .let { detectCollision(coordinates.newX(x = it)) }
        .let { RoverHeadingEast(it, mars) }

    override fun turnLeft(): Rover = RoverHeadingNorth(coordinates, mars)
    override fun turnRight(): Rover = RoverHeadingSouth(coordinates, mars)
    override fun name(): String = "E"
}

data class RoverHeadingWest(val coordinates: Coordinates, val mars: Mars): Rover(coordinates, mars) {
    override fun moveForward(): Rover = this
        .let { mars sphereMinusX coordinates }
        .let { detectCollision(coordinates.newX(x = it)) }
        .let { RoverHeadingWest(it, mars) }

    override fun moveBackward(): Rover = this
        .let { mars spherePlusX coordinates }
        .let { detectCollision(coordinates.newX(x = it)) }
        .let { RoverHeadingWest(it, mars) }

    override fun turnLeft(): Rover = RoverHeadingSouth(coordinates, mars)
    override fun turnRight(): Rover = RoverHeadingNorth(coordinates, mars)
    override fun name(): String = "W"
}