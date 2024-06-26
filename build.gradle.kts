// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    alias(libs.plugins.serialization) apply false
    alias(libs.plugins.androidLibrary) apply false
//    id("org.jetbrains.kotlin.plugin.serialization") version '1.7.10' apply false
//    alias(libs.plugins.ksp) apply false
}