package pl.stosik.mars.rover.domain.rover

import pl.stosik.mars.rover.domain.exception.UnsupportedDirectionException
import pl.stosik.mars.rover.domain.value.Coordinates
import pl.stosik.mars.rover.domain.value.Mars

object RoverFactory {
    fun create(coordinates: Coordinates, direction: String, mars: Mars): Rover = when(direction) {
        "N" -> RoverHeadingNorth(coordinates, mars)
        "S" -> RoverHeadingSouth(coordinates, mars)
        "E" -> RoverHeadingEast(coordinates, mars)
        "W" -> RoverHeadingWest(coordinates, mars)
        else -> throw UnsupportedDirectionException("Unsupported direction of rover")
    }
}