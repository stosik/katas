package pl.stosik.mars.rover.domain.value

data class Coordinates(val x: Int, val y: Int) {
    fun newX(x: Int) = Coordinates(x, y)
    fun newY(y: Int) = Coordinates(x, y)
}