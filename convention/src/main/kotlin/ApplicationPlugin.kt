import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import plugin.ApplicationPlugin
import util.android.defaultConfig
import util.dependencies.CoreImplementation

class ApplicationPlugin : ApplicationPlugin() {
    override fun Project.applyTarget(extension: ApplicationExtension, libs: VersionCatalog) {
        with(pluginManager) {
            apply("com.hoangdv.core")
        }
        extension.defaultConfig(this)
    }
}