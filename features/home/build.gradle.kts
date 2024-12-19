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
    "implementation"(libs.ktorAndroid)
    "implementation"(libs.bundles.archComponents)
    "implementation"(libs.bundles.kotlinCoroutines)

    "implementation"(project(":core:sharedData"))
    "implementation"(project(":core:network"))
    "implementation"(project(":core:utils"))
    "implementation"(project(":core:ui"))


    "testImplementation"(libs.ktor.client.mock)
    "testImplementation"(libs.ktorContentNegotiation)
    "testImplementation"(libs.ktorSerialization)
    "kspTest"( libs.hilt.compiler)

    "testImplementation"(libs.bundles.unit.test)
    "androidTestImplementation"(libs.bundles.ui.test)
    "kspAndroidTest"(libs.hiltDaggerCompiler)


}
