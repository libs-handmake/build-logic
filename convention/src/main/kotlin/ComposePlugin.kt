import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import util.Settings

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            val exts = extensions.findByType<ApplicationExtension>()
                ?: extensions.findByType<LibraryExtension>() ?: return
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            with(exts) {
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = Settings.COMPOSE_COMPILER_VER
                }
            }

            dependencies {
                "implementation"(libs.findLibrary("androidx-activity-compose").get())
                "implementation"(platform(libs.findLibrary("androidx-compose-bom").get()))
                "implementation"(libs.findLibrary("androidx-ui").get())
                "implementation"(libs.findLibrary("androidx-ui-graphics").get())
                "implementation"(libs.findLibrary("androidx-ui-tooling-preview").get())
                "implementation"(libs.findLibrary("androidx-material3").get())
                "androidTestImplementation"(
                    platform(
                        libs.findLibrary("androidx-compose-bom").get()
                    )
                )
                "androidTestImplementation"(libs.findLibrary("androidx-ui-test-junit4").get())
                "debugImplementation"(libs.findLibrary("androidx-ui-tooling").get())
                "debugImplementation"(libs.findLibrary("androidx-ui-test-manifest").get())

                "implementation"(libs.findLibrary("androidx-material-icons-core").get())
                "implementation"(libs.findLibrary("androidx-material-icons-extended").get())
                "implementation"(libs.findLibrary("androidx-material3-windowSize").get())
                "implementation"(libs.findLibrary("androidx-activity-compose").get())
                "implementation"(libs.findLibrary("androidx-lifecycle-viewmodel-compose").get())
                "implementation"(libs.findLibrary("androidx-lifecycle-runtime-compose").get())
                "implementation"(libs.findLibrary("androidx-navigation-compose").get())
                "implementation"(libs.findLibrary("androidx-hilt-navigation-compose").get())
                "implementation"(libs.findLibrary("glide-compose").get())
                "implementation"(libs.findLibrary("androidx-constraintlayout-compose").get())
                "implementation"(libs.findLibrary("sdp-compose").get())
                "implementation"(libs.findLibrary("lottie-compose").get())
            }
        }
    }
}