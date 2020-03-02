group = "com.github.monosoul"
version = "0.0.1"

plugins {
    kotlin("multiplatform") version "1.3.61"
}

repositories {
    mavenCentral()
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    linuxX64("linux") {
        binaries {
            executable()
        }
    }

    mingwX64("windows") {
        binaries {
            executable()
        }
    }
    
    macosX64("macos") {
        binaries {
            executable()
        }
    }
}