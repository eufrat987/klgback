plugins {
    id("java")
//    id("org.springframework.boot") version "3.2.3"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}


group = "klg.backend.lukasz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.3")

}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest.attributes["Main-Class"] = "klg.backend.lukasz.Main"
}