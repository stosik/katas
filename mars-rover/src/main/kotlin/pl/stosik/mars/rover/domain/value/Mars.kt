package pl.stosik.mars.rover.domain.value

data class Mars(val width: Int, val height: Int, val obstacles: Obstacles = Obstacles.empty())

infix fun Mars.spherePlusX(coordinates: Coordinates) = (coordinates.x + 1) % this.width
infix fun Mars.sphereMinusX(coordinates: Coordinates) = if (coordinates.x > 0) coordinates.x - 1 else this.width - 1
infix fun Mars.spherePlusY(coordinates: Coordinates) = (coordinates.y + 1) % this.height
infix fun Mars.sphereMinusY(coordinates: Coordinates) = if (coordinates.y > 0) coordinates.y - 1 else this.height - 1