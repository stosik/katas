package pl.stosik.mars.rover

import groovy.transform.CompileStatic

import pl.stosik.mars.rover.domain.value.Coordinates

@CompileStatic
trait SampleCoordinates {
    Coordinates onyByOne = createCoordinates(1,1)
    Coordinates zeroByZero = createCoordinates(0,0)

    static Coordinates createCoordinates(int x, int y) {
        return new Coordinates(x, y)
    }
}
