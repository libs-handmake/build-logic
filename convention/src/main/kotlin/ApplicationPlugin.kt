import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import plugin.ApplicationPlugin
import util.android.defaultConfig
import java.time.Duration
import java.time.Instant

class ApplicationPlugin : ApplicationPlugin() {
    override fun Project.applyTarget(extension: ApplicationExtension, libs: VersionCatalog) {
        with(pluginManager) {
            apply("com.hoangdv.core")
        }
        extension.defaultConfig(this)

        gradle.taskGraph.whenReady {
            allTasks.forEach {
                var time = Instant.now()
                it.doFirst {
                    time = Instant.now()
                }
                it.doLast {
                    print(
                        "\u001b[32mtask: ${it.name} took ${
                            Duration.between(time, Instant.now()).toMillis()
                        }ms\n\u001b[0m"
                    )
                }
            }
        }
    }
}