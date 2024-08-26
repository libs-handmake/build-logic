package util

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object Settings {
    const val TARGET_SDK = 34
    const val MIN_SDK = 24
    const val COMPOSE_COMPILER_VER = "1.5.1"

    val javaCompatibility = JavaVersion.VERSION_1_8
    val javaTarget = "1.8"

    val jvmTarget = JvmTarget.JVM_1_8

}