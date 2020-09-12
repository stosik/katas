package pl.stosik.mars.rover

import groovy.transform.CompileStatic

import pl.stosik.mars.rover.domain.rover.Rover
import pl.stosik.mars.rover.domain.rover.RoverHeadingEast
import pl.stosik.mars.rover.domain.rover.RoverHeadingNorth
import pl.stosik.mars.rover.domain.rover.RoverHeadingSouth
import pl.stosik.mars.rover.domain.rover.RoverHeadingWest
import pl.stosik.mars.rover.domain.value.Coordinates
import pl.stosik.mars.rover.domain.value.Mars
import pl.stosik.mars.rover.domain.value.Obstacles

@CompileStatic
trait SampleRovers implements SampleCoordinates, SampleMarses {

    Rover roverHeadingNorth = createRover(1, 1, "N", new Mars(10, 10, new Obstacles([])))
    Rover roverHeadingSouth = createRover(1, 1, "S",  new Mars(10, 10, new Obstacles([])))
    Rover roverHeadingEast = createRover(1, 1, "E", new Mars(10, 10, new Obstacles([])))
    Rover roverHeadingWest = createRover(1, 1, "W", new Mars(10, 10, new Obstacles([])))

    static Rover createRover(int initialX, int initialY, String initialDirection, Mars mars) {
        if (initialDirection == "N")
            return new RoverHeadingNorth(new Coordinates(initialX, initialY), mars)
        else if (initialDirection == "E")
            return new RoverHeadingEast(new Coordinates(initialX, initialY), mars)
        else if (initialDirection == "S")
            return new RoverHeadingSouth(new Coordinates(initialX, initialY), mars)
        else (initialDirection == "W")
            return new RoverHeadingWest(new Coordinates(initialX, initialY), mars)
    }
}
