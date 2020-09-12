package pl.stosik.mars.rover

import pl.stosik.mars.rover.domain.rover.RoverHeadingEast
import pl.stosik.mars.rover.domain.rover.RoverHeadingSouth
import pl.stosik.mars.rover.domain.rover.RoverHeadingWest
import pl.stosik.mars.rover.domain.value.Coordinates

import spock.lang.Specification

class RoverHeadingSouthSpec extends Specification implements SampleRovers {

    def "should rover be heading west when turned right" () {
        given:
        def rover = roverHeadingSouth

        when:
        def expectedRover = rover.turnRight()

        then:
        expectedRover instanceof RoverHeadingWest
    }

    def "should rover be heading east when turned left" () {
        given:
        def rover = roverHeadingSouth

        when:
        def expectedRover = rover.turnLeft()

        then:
        expectedRover instanceof RoverHeadingEast
    }

    def "should give rover's direction name" () {
        given:
        def rover = roverHeadingSouth

        when:
        def expectedRoverName = rover.name()

        then:
        expectedRoverName == "S"
    }

    def "should rover move forward" () {
        given:
        def rover = new RoverHeadingSouth(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveForward()

        then:
        expectedRover == new RoverHeadingSouth(new Coordinates(1, 0), marsWithoutObstacles)
    }

    def "should rover move backward" () {
        given:
        def rover = new RoverHeadingSouth(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveBackward()

        then:
        expectedRover == new RoverHeadingSouth(new Coordinates(1, 2), marsWithoutObstacles)
    }
}
