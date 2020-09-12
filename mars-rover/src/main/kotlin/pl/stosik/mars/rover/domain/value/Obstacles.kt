package pl.stosik.mars.rover.domain.value

data class Obstacles(val coordinates: List<Coordinates>) {
    fun contains(coordinate: Coordinates) = coordinates.contains(coordinate)

    companion object {
        fun empty() = Obstacles(emptyList())
    }
}