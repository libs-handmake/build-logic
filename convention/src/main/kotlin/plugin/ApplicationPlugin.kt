package plugin

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

abstract class ApplicationPlugin : Plugin<Project> {

    abstract fun Project.applyTarget(extension: ApplicationExtension, libs: VersionCatalog)

    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<ApplicationExtension>()
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            applyTarget(extension, libs)
        }
    }
}