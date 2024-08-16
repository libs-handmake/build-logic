package util.dependencies

import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.DependencyHandlerScope

abstract class Implementation(protected val libs: VersionCatalog, protected val scope:DependencyHandlerScope) {
    abstract fun implementation()
}