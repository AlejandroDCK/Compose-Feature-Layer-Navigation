// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.jetbrainsKotlinSerialization) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("io.gitlab.arturbosch.detekt") version "1.23.7"
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        buildUponDefaultConfig = true
        allRules = false
    }
}

tasks.register("detektAll"){
    dependsOn(subprojects.map { "${it.path}:detekt" })
}