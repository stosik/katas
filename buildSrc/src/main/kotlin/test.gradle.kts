plugins {
    `java-library`
}

val spek = "2.0.10"
val spock = "1.3-groovy-2.5"
val spockReports = "1.6.2"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek")
    testImplementation("org.mockito:mockito-core:2.23.4")
    testImplementation("junit:junit:4.12")
    testImplementation("org.spockframework:spock-core:$spock")
    testImplementation("com.athaydes:spock-reports:$spockReports")
    testImplementation("org.codehaus.groovy:groovy-all:2.4.15")

    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}