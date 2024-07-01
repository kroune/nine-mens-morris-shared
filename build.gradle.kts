plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "2.0.0"
    `maven-publish`
}

group = "com.kroune"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(8)
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.github.kroune:9-men-s-morris-lib:297220e0e1")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.kroune"
            artifactId = "nine-mens-morris-shared"
            version = "1.0.0"

            from(components["java"])
        }
    }
}