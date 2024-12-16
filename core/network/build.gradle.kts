apply {
    from("$rootDir/android-library-build.gradle")
}


plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    id("kotlinx-serialization")
    alias(libs.plugins.secrets)
    alias(libs.plugins.kotlin.compose)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "${rootProject.extra.get("applicationId")}.core.network"
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    "implementation"(libs.bundles.networking)
}
