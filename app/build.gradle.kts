plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.operatorapplication"
    compileSdk = 33

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.operatorapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }

    flavorDimensions.add("client")
    productFlavors {
        create("OperatorA") {
            dimension = "client"
            applicationIdSuffix = ".operatorA"
            versionNameSuffix = "-OperatorA"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorA\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#FF5733\"")
        }
        create("OperatorB") {
            dimension = "client"
            applicationIdSuffix = ".operatorB"
            versionNameSuffix = "-OperatorB"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorB\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#33FF57\"")
        }
        create("OperatorC") {
            dimension = "client"
            applicationIdSuffix = ".operatorC"
            versionNameSuffix = "-OperatorC"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorC\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#3357FF\"")
        }
        create("OperatorD") {
            dimension = "client"
            applicationIdSuffix = ".operatorD"
            versionNameSuffix = "-OperatorD"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorD\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#FF33A1\"")
        }
        create("OperatorE") {
            dimension = "client"
            applicationIdSuffix = ".operatorE"
            versionNameSuffix = "-OperatorE"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorE\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#A133FF\"")
        }
        create("OperatorF") {
            dimension = "client"
            applicationIdSuffix = ".operatorF"
            versionNameSuffix = "-OperatorF"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorF\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#FF8C33\"")
        }
        create("OperatorG") {
            dimension = "client"
            applicationIdSuffix = ".operatorG"
            versionNameSuffix = "-OperatorG"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorG\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#33FF8C\"")
        }
        create("OperatorH") {
            dimension = "client"
            applicationIdSuffix = ".operatorH"
            versionNameSuffix = "-OperatorH"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorH\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#8C33FF\"")
        }
        create("OperatorI") {
            dimension = "client"
            applicationIdSuffix = ".operatorI"
            versionNameSuffix = "-OperatorI"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorI\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#FF3333\"")
        }
        create("OperatorJ") {
            dimension = "client"
            applicationIdSuffix = ".operatorJ"
            versionNameSuffix = "-OperatorJ"
            buildConfigField("String", "CLIENT_NAME", "\"OperatorJ\"")
            buildConfigField("String", "CLIENT_COLOR", "\"#33FFA1\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib", "1.8.0"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")

    testImplementation("org.robolectric:robolectric:4.9")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.huawei.hms:location:6.9.0.300")

    testImplementation ("org.mockito:mockito-core:4.5.1")
    testImplementation ("org.mockito:mockito-inline:4.5.1")
}
