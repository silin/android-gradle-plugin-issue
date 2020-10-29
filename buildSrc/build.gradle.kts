plugins {
    `kotlin-dsl`
}

repositories {
    maven("http://maven-repo2.iggroup.local:8081/nexus/content/groups/public")
}

dependencies {
//    implementation("com.android.tools.build:gradle:4.0.2")
//    implementation("com.android.tools.build:gradle:4.1.0-alpha07")
    implementation("com.android.tools.build:gradle:4.1.0-alpha08")
//    implementation("com.android.tools.build:gradle:4.1.0")
}