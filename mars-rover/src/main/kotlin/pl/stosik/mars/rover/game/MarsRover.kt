package pl.stosik.mars.rover.game

import pl.stosik.mars.rover.domain.MarsRoverFacade
import pl.stosik.mars.rover.domain.rover.Rover
import pl.stosik.mars.rover.domain.rover.RoverFactory

object MarsRover {
    fun run() = readMars()
        .let { mars -> readObstacles().let { obstacles -> mars.copy(obstacles = obstacles) } }
        .let { mars -> readCoordinates().let { coordinates -> readDirection().let { direction -> RoverFactory.create(coordinates, direction, mars) } } }
        .let { rover -> gameLoop(rover) }

    private fun gameLoop(rover: Rover) {
        val marsRoverFacade = MarsRoverFacade()
        var movingRover = rover

        do {
            movingRover = marsRoverFacade.execute(
                rover = movingRover,
                input = readCommand()
            )
            display(movingRover)
        } while(true)
    }
}
