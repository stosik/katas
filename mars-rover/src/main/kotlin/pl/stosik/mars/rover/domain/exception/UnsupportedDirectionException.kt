package pl.stosik.mars.rover.domain.exception

import java.lang.RuntimeException

class UnsupportedDirectionException(override val message: String): RuntimeException(message)