plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.compose)
    id("io.gitlab.arturbosch.detekt")
}


android {
    namespace = "com.novastudio.composefeaturelayernavigation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.novastudio.composefeaturelayernavigation"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.raamCosta.composeDestinations)
    ksp(libs.ksp)
    detektPlugins(libs.detekt.formatting)
}

tasks.register<Copy>("copyPreCommitHook") {
    description = "Copy pre-commit hook from scripts to .git/hooks"
    group = "git hooks"
    outputs.upToDateWhen { false }
    from(file("$rootDir/scripts/pre-commit"))
    into(file("$rootDir/.git/hooks/"))
    include("pre-commit")
}

tasks.build {
    dependsOn("copyPreCommitHook")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        xml.required = true
        html.required = true
        txt.required = true
    }
    kotlin { jvmTarget = "1.8" }
}

