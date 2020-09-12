plugins {
    kotlin
    test
    id("groovy")
}

sourceSets {
    test {
        withConvention(GroovySourceSet::class) {
            groovy {
                setSrcDirs(listOf("src/test/groovy", "src/integration-test/groovy"))
                setIncludes(listOf("**/*.groovy"))
            }
        }
    }
}