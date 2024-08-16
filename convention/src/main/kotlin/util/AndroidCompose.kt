import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAndroidCompose(
    commonExtension: BaseAppModuleExtension
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("composeCompiler").get().toString()
        }
    }
}
