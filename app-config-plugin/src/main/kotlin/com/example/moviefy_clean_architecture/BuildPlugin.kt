package com.example.moviefy_clean_architecture

import ProjectProperties
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.util.Properties

class BuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {


    }
}


private fun Project.loadProperties(): ProjectProperties {

    val projectProperties = Properties()

    projectProperties.load(
        InputStreamReader(
            ByteArrayInputStream(
                providers.fileContents(layout.projectDirectory.file("../apikey.properties"))
                    .asBytes
                    .forUseAtConfigurationTime()
                    .orNull
                    ?: throw GradleException("Mission apikey.properties")
            )
        )
    )

    return ProjectProperties(apiKey = projectProperties.getProperty("API_KEY"))
}