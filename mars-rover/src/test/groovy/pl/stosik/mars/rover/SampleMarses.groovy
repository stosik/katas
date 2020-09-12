package pl.stosik.mars.rover

import groovy.transform.CompileStatic

import pl.stosik.mars.rover.domain.value.Mars
import pl.stosik.mars.rover.domain.value.Obstacles

@CompileStatic
trait SampleMarses {

    Mars marsWithoutObstacles = createMars(10, 10, new Obstacles([]))

    static Mars createMars(int width, int height, Obstacles obstacles) {
        return new Mars(width, height, obstacles)
    }
}