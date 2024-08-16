import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class FirebasePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.google.gms.google-services")
            }

            dependencies {
                "implementation"(platform(libs.findLibrary("firebase-bom").get()))
                "implementation"(libs.findLibrary("firebase-analytics").get())
                "implementation"(libs.findLibrary("firebase-config").get())
            }
        }
    }
}