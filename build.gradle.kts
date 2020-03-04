group = "com.github.monosoul"
version = "0.0.1"

plugins {
    kotlin("multiplatform") version "1.3.70"
}

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")

    // Create target for the host platform.
    val hostTarget = when {
        hostOs == "Mac OS X" -> macosX64("helloworld")
        hostOs == "Linux" -> linuxX64("helloworld")
        hostOs.startsWith("Windows") -> mingwX64("helloworld")
        else -> throw GradleException("Host OS '$hostOs' is not supported in Kotlin/Native $project.")
    }

    hostTarget.apply {
        binaries {
            executable()
        }
    }
}