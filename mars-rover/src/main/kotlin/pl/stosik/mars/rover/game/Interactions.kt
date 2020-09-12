package pl.stosik.mars.rover.game

import pl.stosik.mars.rover.domain.rover.Rover
import pl.stosik.mars.rover.domain.value.Coordinates
import pl.stosik.mars.rover.domain.value.Mars
import pl.stosik.mars.rover.domain.value.Obstacles

val readMars: () -> Mars = { ask("Insert horizontal and vertical map size as (n x m):").let(parsePlanet) }
val readObstacles: () -> Obstacles = { ask("Where are the obstacles?").let(parseObstacles) }
val readCoordinates: () -> Coordinates = { ask("Insert horizontal and vertical initial rover position as (x, y):").let(parseCoordinates) }
val readDirection: () -> String = { ask("Enter one of rover direction(N, S, E, W):").let(parseDirection) }
val readCommand: () -> String = { ask("Insert command (F = forward, B = backward, L = turn left, R = turn right):").let(parseCommand) }
val display: (Rover) -> Unit = { rover -> puts("Rover is at x:${rover.position()}") }
