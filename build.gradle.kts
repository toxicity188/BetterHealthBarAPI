plugins {
    `java-library`
    `maven-publish`
}

group = "kor.toxicity.betterhealthbar.api"
version = "2.0.0"

val adventureVersion = "4.14.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-api:${adventureVersion}")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks {
    test {
        useJUnitPlatform()
    }
    jar {
        archiveFileName.set("BetterHealthBar-API.jar")
    }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
    }
}