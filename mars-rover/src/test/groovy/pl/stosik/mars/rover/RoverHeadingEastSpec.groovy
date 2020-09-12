package pl.stosik.mars.rover

import pl.stosik.mars.rover.domain.rover.RoverHeadingEast
import pl.stosik.mars.rover.domain.rover.RoverHeadingNorth
import pl.stosik.mars.rover.domain.rover.RoverHeadingSouth
import pl.stosik.mars.rover.domain.value.Coordinates
import spock.lang.Specification

class RoverHeadingEastSpec extends Specification implements SampleRovers {

    def "should rover be heading south when turned right" () {
        given:
        def rover = roverHeadingEast

        when:
        def expectedRover = rover.turnRight()

        then:
        expectedRover instanceof RoverHeadingSouth
    }

    def "should rover be heading north when turned left" () {
        given:
        def rover = roverHeadingEast

        when:
        def expectedRover = rover.turnLeft()

        then:
        expectedRover instanceof RoverHeadingNorth
    }

    def "should give rover's direction name" () {
        given:
        def rover = roverHeadingEast

        when:
        def expectedRoverName = rover.name()

        then:
        expectedRoverName == "E"
    }

    def "should rover move forward" () {
        given:
        def rover = new RoverHeadingEast(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveForward()

        then:
        expectedRover == new RoverHeadingEast(new Coordinates(2, 1), marsWithoutObstacles)
    }

    def "should rover move backward" () {
        given:
        def rover = new RoverHeadingEast(new Coordinates(1, 1), marsWithoutObstacles)

        when:
        def expectedRover = rover.moveBackward()

        then:
        expectedRover == new RoverHeadingEast(new Coordinates(0, 1), marsWithoutObstacles)
    }
}
