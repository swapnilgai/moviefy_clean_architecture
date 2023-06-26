pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
include(":network-service-module")
include(":network-infra-module")
include(":common")
include(":interactor")
include(":common-ui")
include(":navigation")
includeBuild("app-config-plugin")
