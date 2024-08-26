plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.gradleAndroid)
    compileOnly(libs.koltinGradlePlugin)
    compileOnly(libs.plugin.android)
//    implementation(libs.plugin.firebase.appdistribution)
    compileOnly(libs.plugin.firebase.crashlytics)
//    implementation(libs.plugin.firebase.performance)
}

gradlePlugin {
    plugins {
        register("hoangdv_application") {
            id = libs.plugins.hoangdv.application.get().pluginId//"com.hoangdv.application"
            implementationClass = "ApplicationPlugin"
        }
    }

    plugins {
        register("hoangdv_library") {
            id = libs.plugins.hoangdv.library.get().pluginId//"com.hoangdv.library"
            implementationClass = "LibraryPlugin"
        }
    }

    plugins {
        register("hoangdv_core_impl") {
            id = libs.plugins.hoangdv.core.get().pluginId//"com.hoangdv.core"
            implementationClass = "CorePlugin"
        }
    }

    plugins {
        register("hoangdv_jetpack_compose") {
            id = libs.plugins.hoangdv.jetpack.compose.get().pluginId//"com.hoangdv.jetpack.compose"
            implementationClass = "ComposePlugin"
        }
    }

    //third-party
    plugins {
        register("hoangdv_firebase_core") {
            id = libs.plugins.hoangdv.firebase.core.get().pluginId//"com.hoangdv.firebase"
            implementationClass = "FirebasePlugin"
        }
    }
    plugins {
        register("hoangdv_firebase_crashlytics") {
            id =
                libs.plugins.hoangdv.firebase.crashlytic.get().pluginId //"com.hoangdv.firebase.crashlytic"
            implementationClass = "CrashlyticPlugin"
        }
    }

}
