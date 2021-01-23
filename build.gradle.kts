import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.compose.compose

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.21"
    id("org.jetbrains.compose") version "0.3.0-build141"
}

val kotlinVersion = "1.4.21"
val ktorVersion = "1.5.0"

repositories {
    mavenCentral()
    jcenter()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    //implementation(kotlin("stdlib-jdk8"))

    // Kotlin Standard Library & Reflection
    implementation(kotlin("stdlib", version = kotlinVersion))
    implementation(kotlin("reflect", version = kotlinVersion))

    // UI: Jetbrains Compose
    implementation(compose.desktop.currentOs)

    // Serialization
    implementation(kotlin("serialization", version = kotlinVersion))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

}

