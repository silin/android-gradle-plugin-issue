plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
}

dependencies {
//    implementation("com.android.tools.build:gradle:4.0.2")  // <-- WORKS
//    implementation("com.android.tools.build:gradle:4.1.0-alpha07") // <-- WORKS
    implementation("com.android.tools.build:gradle:4.1.0-alpha08") // <-- DOES NOT WORK
//    implementation("com.android.tools.build:gradle:4.1.0") // <-- DOES NOT WORK
}