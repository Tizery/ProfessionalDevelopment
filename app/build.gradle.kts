plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.professionaldevelopment"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.SWIPE_REFRESH_LAYOUT)
    //Retrofit 2
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_GSON)
    implementation(Dependencies.OKHTTP3_LOGGING_INTERCEPTOR)
    implementation(Dependencies.RETROFIT2_KOTLIN_COROUTINES_ADAPTER)
    //RxJava
    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RX_JAVA)
    //Koin
    implementation(Dependencies.KOIN_CORE)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_ANDROID_COMPAT)
    //Picasso
    implementation(Dependencies.PICASSO)
    //Glide
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)
    //Coil
    implementation(Dependencies.COIL)
    //Room
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)
    implementation(Dependencies.ROOM_KTX)

    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.TEST_EXT_JUNIT)
    androidTestImplementation(Dependencies.TEST_ESPRESSO_CORE)
}