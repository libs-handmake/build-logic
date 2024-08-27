import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class CorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.plugin.parcelize")
                apply("com.google.devtools.ksp")
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("androidx-core-ktx").get())
                "implementation"(libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
                "testImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-espresso-core").get())
                "implementation"(libs.findLibrary("androidx-appcompat").get())
                "implementation"(libs.findLibrary("material").get())
                "implementation"(libs.findLibrary("androidx-constraintlayout").get())
                "implementation"(libs.findLibrary("androidx-recyclerview").get())
                "implementation"(libs.findLibrary("gson").get())
                "implementation"(libs.findLibrary("sdp-android").get())
                "implementation"(libs.findLibrary("ssp-android").get())
                "implementation"(libs.findLibrary("circleimageview").get())
                "implementation"(libs.findLibrary("eventbus").get())
                "implementation"(libs.findLibrary("hilt-android").get())
                "ksp"(libs.findLibrary("hilt-android-compiler").get())
                "implementation"(libs.findLibrary("androidx-fragment-ktx").get())
                "implementation"(libs.findLibrary("androidx-activity").get())
                "implementation"(libs.findLibrary("androidx-activity-ktx").get())
                "implementation"(libs.findLibrary("roundedimageview").get())
                "implementation"(libs.findLibrary("glide").get())
                "implementation"(libs.findLibrary("lottie").get())
                "ksp"(libs.findLibrary("glide-compiler").get())
            }

//            extensions.getByType<KaptExtension>().apply {
//                correctErrorTypes = true
//            }
        }
    }
}