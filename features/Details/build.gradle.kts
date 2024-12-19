apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.kotlin.compose)
}


dependencies {

    val composeBom = platform(libs.androidx.compose.bom)
    "implementation"(composeBom)
    "implementation"(libs.bundles.jetpackCompost)
    "implementation"(libs.hiltNavigationCompose)
    "implementation"(libs.bundles.archComponents)
    "implementation"(libs.bundles.kotlinCoroutines)
    "implementation"(libs.ktorAndroid)

    "implementation"(project(":core:utils"))
    "implementation"(project(":core:ui"))
    "implementation"(project(":core:sharedData"))
    "implementation"(project(":core:network"))



}
