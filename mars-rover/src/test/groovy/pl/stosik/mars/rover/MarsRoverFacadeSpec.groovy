package pl.stosik.mars.rover

import pl.stosik.mars.rover.domain.MarsRoverFacade
import pl.stosik.mars.rover.domain.value.Coordinates
import pl.stosik.mars.rover.domain.value.Obstacles

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MarsRoverFacadeSpec extends Specification implements SampleRovers, SampleMarses {

    @Shared
    def roverFacade = new MarsRoverFacade()

    @Unroll
    def 'should return initial position of rover without any command' () {
        given:
        def emptyCommand = ""
        def rover = createRover(initialX, initialY, initialDirection, marsWithoutObstacles)

        when:
        def actualCoordinates = roverFacade.execute(rover, emptyCommand).position()

        then:
        actualCoordinates == expectedCoordinates

        where:
        initialX | initialY | initialDirection   || expectedCoordinates
        1        | 2        | "N"                || "1 2 N"
        1        | 3        | "N"                || "1 3 N"
    }

    @Unroll
    def 'should move rover' () {
        given:
        def rover = createRover(initialX, initialY, initialDirection, marsWithoutObstacles)

        when:
        def actualCoordinates = roverFacade.execute(rover, commands).position()

        then:
        actualCoordinates == expectedCoordinates

        where:
        initialX | initialY | initialDirection  | commands   || expectedCoordinates
        1        | 2        | "N"               | "F"        || "1 3 N"
        1        | 3        | "N"               | "FFF"      || "1 6 N"
        1        | 8        | "S"               | "F"        || "1 7 S"
        1        | 1        | "E"               | "F"        || "2 1 E"
        1        | 1        | "E"               | "FFF"      || "4 1 E"
        8        | 1        | "W"               | "F"        || "7 1 W"
        1        | 2        | "N"               | "B"        || "1 1 N"
        1        | 2        | "W"               | "BB"       || "3 2 W"
        1        | 2        | "S"               | "B"        || "1 3 S"
    }

    @Unroll
    def 'should turn rover' () {
        given:
        def rover = createRover(1, 1, initialDirection, marsWithoutObstacles)

        when:
        def actualPosition = roverFacade.execute(rover, commands).position()
        def expectedPosition = "1 1 " + expectedDirection

        then:
        actualPosition == expectedPosition

        where:
        initialDirection     | commands    || expectedDirection
        "N"                  | "R"         || "E"
        "N"                  | "RR"        || "S"
        "N"                  | "RRR"       || "W"
        "N"                  | "RRRR"      || "N"
        "N"                  | "L"         || "W"
        "N"                  | "LL"        || "S"
        "N"                  | "LLL"       || "E"
        "N"                  | "LLLL"      || "N"
        "N"                  | "LR"        || "N"
        "E"                  | "RRLL"      || "E"
    }

    @Unroll
    def 'should move and turn rover' () {
        given:
        def rover = createRover(initialX, initialY, initialDirection, marsWithoutObstacles)

        when:
        def actualCoordinates  = roverFacade.execute(rover, commands).position()

        then:
        actualCoordinates  == expectedCoordinates

        where:
        initialX | initialY | initialDirection  | commands     || expectedCoordinates
        1        | 2        | "N"               | "LFLFLFLFF"  || "1 3 N"
    }

    @Unroll
    def 'should not move rover when met obstacle' () {
        given:
        def mars = createMars(10, 10, new Obstacles([new Coordinates(1, 3)]))
        def rover = createRover(initialX, initialY, initialDirection, mars)

        when:
        def actualCoordinates  = roverFacade.execute(rover, commands).position()

        then:
        actualCoordinates  == expectedCoordinates

        where:
        initialX | initialY | initialDirection  | commands  || expectedCoordinates
        1        | 2        | "N"               | "F"       || "1 2 N"
    }
}