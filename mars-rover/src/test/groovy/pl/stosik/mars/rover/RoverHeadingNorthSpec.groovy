package pl.stosik.mars.rover

import pl.stosik.mars.rover.domain.rover.RoverHeadingEast
import pl.stosik.mars.rover.domain.rover.RoverHeadingNorth
import pl.stosik.mars.rover.domain.rover.RoverHeadingWest
import pl.stosik.mars.rover.domain.value.Coordinates

import spock.lang.Specification

class RoverHeadingNorthSpec extends Specification implements SampleRovers {

    def "should rover be heading east when turned right" () {
        given:
        def rover = roverHeadingNorth

        when:
        def expectedRover = rover.turnRight()

        then:
        expectedRover instanceof RoverHeadingEast
    }

    def "should rover be heading west when turned left" () {
        given:
        def rover = roverHeadingNorth

        when:
        def expectedRover = rover.turnLeft()

        then:
        expectedRover instanceof RoverHeadingWest
    }

    def "should give rover's direction name" () {
        given:
        def rover = roverHeadingNorth

        when:
        def expectedRoverName = rover.name()

        then:
        expectedRoverName == "N"
    }

    def "should rover move forward" () {
        given:
        def rover = new RoverHeadingNorth(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveForward()

        then:
        expectedRover == new RoverHeadingNorth(new Coordinates(1, 2), marsWithoutObstacles)
    }

    def "should rover move backward" () {
        given:
        def rover = new RoverHeadingNorth(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveBackward()

        then:
        expectedRover == new RoverHeadingNorth(new Coordinates(1, 0), marsWithoutObstacles)
    }
}
