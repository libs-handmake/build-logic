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
    implementation(libs.plugin.android)
    implementation(libs.plugin.firebase.appdistribution)
    implementation(libs.plugin.firebase.crashlytics)
    implementation(libs.plugin.firebase.performance)
}

gradlePlugin {
    plugins {
        register("hoangdv_application") {
            id = "com.hoangdv.application"
            implementationClass = "ApplicationPlugin"
        }
    }

    plugins {
        register("hoangdv_core_impl") {
            id = "com.hoangdv.core"
            implementationClass = "CorePlugin"
        }
    }

    plugins {
        register("hoangdv_jetpack_compose") {
            id = "com.hoangdv.jetpack.compose"
            implementationClass = "ComposePlugin"
        }
    }

    //third-party
    plugins {
        register("hoangdv_firebase_core") {
            id = "com.hoangdv.firebase"
            implementationClass = "FirebasePlugin"
        }
    }
    plugins {
        register("hoangdv_firebase_crashlytics") {
            id = "com.hoangdv.firebase.crashlytic"
            implementationClass = "CrashlyticPlugin"
        }
    }

}
