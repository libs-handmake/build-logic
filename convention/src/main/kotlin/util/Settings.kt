package util

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object Settings {
    const val TARGET_SDK = 34
    const val MIN_SDK = 24
    const val COMPOSE_COMPILER_VER = "1.5.3"

    val javaCompatibility = JavaVersion.VERSION_17

    val jvmTarget = JvmTarget.JVM_17

}