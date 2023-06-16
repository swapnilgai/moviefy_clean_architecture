package com.example.moviefy_clean_architecture

import ProjectProperties
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.extra
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Properties

class BuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            setApiProperties(getLocalProperty())
        }
    }
}

internal fun Project.getLocalProperty(file: String = "apikey.properties"): ProjectProperties {
    val projectProperties = Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            projectProperties.load(reader)
        }
    } else throw GradleException("Mission apikey.properties")

    return ProjectProperties(apiKey = projectProperties.getProperty("API_KEY"))
}

private fun Project.setApiProperties(projectProperties: ProjectProperties){
    rootProject.extra.set("ProjectProperties", projectProperties)
}

fun Project.projectProperties() : Provider<ProjectProperties> = provider { rootProject.extra.get("ProjectProperties") as ProjectProperties }