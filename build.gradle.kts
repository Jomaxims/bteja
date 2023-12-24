plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "cz.upce.bteja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.antlr:antlr4:4.13.1")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.21")

    implementation("io.github.oshai:kotlin-logging-jvm:6.0.1")
    implementation("ch.qos.logback:logback-classic:1.4.12")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}