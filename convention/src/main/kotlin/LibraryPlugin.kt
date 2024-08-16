import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import util.android.defaultConfig

class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libExt = extensions.getByType<LibraryExtension>()
            libExt.defaultConfig(target)
        }
    }
}