plugins {
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
}

android {
   namespace = "de.rogallab.mobile"
   compileSdk = 34

   defaultConfig {
      applicationId = "de.rogallab.mobile"
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
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
   }
   kotlinOptions {
      jvmTarget = "17"
   }
   kotlin {
      jvmToolchain(17)
   }
   buildFeatures {
      compose = true
   }
   composeOptions {
      kotlinCompilerExtensionVersion = "1.5.3"
   }
   packaging {
      resources {
         excludes += "/META-INF/{AL2.0,LGPL2.1}"
      }
   }
}

dependencies {

   // https://kotlinlang.org/docs/releases.html
   val kotlinCoroutines = "1.8.1"
   implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutines")
   implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutines")

   // https://developer.android.com/jetpack/androidx/releases/core
   val core = "1.13.1"
   implementation("androidx.core:core-ktx:$core")

   // https://developer.android.com/jetpack/androidx/releases/activity
   val activityCompose = "1.9.0"
   implementation("androidx.activity:activity-compose:$activityCompose")

   // Compose
   implementation(platform("androidx.compose:compose-bom:2024.06.00"))
   implementation("androidx.compose.ui:ui")
   implementation("androidx.compose.ui:ui-graphics")
   implementation("androidx.compose.ui:ui-tooling-preview")
   val material3 = "1.2.1"
   implementation("androidx.compose.material3:material3:$material3")


   // https://developer.android.com/jetpack/androidx/releases/lifecycle
   val lifecycle = "2.8.3"
   // val archVersion = "2.2.0"
   implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")
   implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")
   implementation("androidx.lifecycle:lifecycle-viewmodel-compose-android:$lifecycle")


   // TESTS -----------------------
   testImplementation("junit:junit:4.13.2")

   // ANDROID TESTS ---------------
   // https://developer.android.com/jetpack/androidx/releases/test
   val androidTestCore = "1.6.1"
   // To use the androidx.test.core APIs
   androidTestImplementation("androidx.test:core:$androidTestCore")
   androidTestImplementation("androidx.test:core-ktx:$androidTestCore")

   // To use the androidx.test.espresso
   val espresso = "3.6.1"
   androidTestImplementation("androidx.test.espresso:espresso-core:$espresso")

   // To use the JUnit Extension APIs
   val extJunit = "1.2.1"
   androidTestImplementation("androidx.test.ext:junit:$extJunit")
   androidTestImplementation("androidx.test.ext:junit-ktx:$extJunit")

   // To use the Truth Extension APIs
   val truth = "1.6.0"
   androidTestImplementation("androidx.test.ext:truth:$truth")

   // To use the androidx.test.runner APIs
   val runner = "1.6.1"
   androidTestImplementation("androidx.test:runner:$runner")

   // Kotlin coroutines
   androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutines")

   // To use Compose Testing
   androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
   androidTestImplementation("androidx.compose.ui:ui-test-junit4")
   debugImplementation("androidx.compose.ui:ui-tooling")
   val uiTestManifest = "1.6.8"
   debugImplementation("androidx.compose.ui:ui-test-manifest:$uiTestManifest")

}