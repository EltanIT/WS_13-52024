plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

//    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    alias(libs.plugins.serialization)

}

android {
    namespace = "com.example.ws_13_52024"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ws_13_52024"
        minSdk = 28
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
        kotlinCompilerExtensionVersion = "1.5.5"
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
    implementation(libs.androidx.navigation.testing)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //supabase
    implementation("io.github.jan-tennert.supabase:postgrest-kt:2.2.3")
    implementation("io.github.jan-tennert.supabase:storage-kt:2.2.3")
    implementation("io.github.jan-tennert.supabase:realtime-kt:2.2.3")
    implementation("io.github.jan-tennert.supabase:gotrue-kt:2.2.3")
    implementation("io.github.jan-tennert.supabase:compose-auth:2.2.3")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    //ktor
    implementation("io.ktor:ktor-client-core:2.3.9")
    implementation("io.ktor:ktor-client-cio:2.3.9")

    //gson
    implementation("com.google.code.gson:gson:2.10.1")

    //room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)

    //koin
    implementation(libs.io.koin.compose)
    implementation(libs.io.koin.core)
    implementation(libs.io.koin.android)

    //navigation
    implementation(libs.androidx.navigation)

    //coil
    implementation(libs.io.coil.compose)




}