import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    kotlin("jvm") version "1.6.21"
    application
}

group = "ru.furian"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-logging:2.0.1")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("io.ktor:ktor-server-core:2.0.1")
    implementation("io.ktor:ktor-server-netty:2.0.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}