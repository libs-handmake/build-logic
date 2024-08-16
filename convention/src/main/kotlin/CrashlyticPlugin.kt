import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.the

class CrashlyticPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.hoangdv.firebase")
                apply("com.google.firebase.crashlytics")
            }

            extensions.getByType<BaseAppModuleExtension>().apply {
                buildTypes {
                    release {
                        configure<CrashlyticsExtension> {
                            mappingFileUploadEnabled = true
                        }
                    }
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                "implementation"(libs.findLibrary("firebase-crashlytics").get())
                "implementation"(libs.findLibrary("firebase-crashlytics-ndk").get())
            }
        }
    }
}