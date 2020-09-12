plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    jcenter()
    google()
}

val kotlin = "1.4.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
    implementation("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0")
}