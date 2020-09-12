package pl.stosik.mars.rover.game

import pl.stosik.mars.rover.domain.value.Coordinates
import pl.stosik.mars.rover.domain.value.Mars
import pl.stosik.mars.rover.domain.value.Obstacles

val parsePlanet: (String) -> Mars = { s: String ->
    val tokens = s.split("x")
    Mars(tokens[0].toInt(), tokens[1].toInt())
}

val parseObstacles: (String) -> Obstacles = { s: String ->
    if (s.isEmpty()) Obstacles(emptyList())
    else s.split("/").map(parseCoordinates).let { Obstacles(it) }
}

val parseCoordinates: (String) -> Coordinates = { s: String ->
    val tokens = s.split(",")
    Coordinates(tokens[0].toInt(), tokens[1].toInt())
}

val parseDirection: (String) -> String = { it }

val parseCommand: (String) -> String = { it }
