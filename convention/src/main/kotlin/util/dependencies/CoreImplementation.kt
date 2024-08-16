package util.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.DependencyHandlerScope

class CoreImplementation(libs: VersionCatalog, scope: DependencyHandlerScope) :
    Implementation(libs, scope) {
    override fun implementation() {
        with(scope) {
            "implementation"(libs.findLibrary("androidx-activity-compose").get())
            "implementation"(platform(libs.findLibrary("androidx-compose-bom").get()))
            "implementation"(libs.findLibrary("androidx-ui").get())
            "implementation"(libs.findLibrary("androidx-ui-graphics").get())
            "implementation"(libs.findLibrary("androidx-ui-tooling-preview").get())
            "implementation"(libs.findLibrary("androidx-material3").get())
            "testImplementation"(libs.findLibrary("junit").get())
            "androidTestImplementation"(libs.findLibrary("androidx-junit").get())
            "androidTestImplementation"(libs.findLibrary("androidx-espresso-core").get())
            "androidTestImplementation"(
                platform(
                    libs.findLibrary("androidx-compose-bom").get()
                )
            )
            "androidTestImplementation"(libs.findLibrary("androidx-ui-test-junit4").get())
            "debugImplementation"(libs.findLibrary("androidx-ui-tooling").get())
            "debugImplementation"(libs.findLibrary("androidx-ui-test-manifest").get())
        }

    }
}