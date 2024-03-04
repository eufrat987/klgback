plugins {
    id("org.springframework.boot") version "3.2.3"
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

//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.3")
//    testImplementation("junit:junit:4.13.2")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

//    testImplementation("org.junit.jupiter:junit-jupiter")
//    testImplementation("org.junit.jupiter:junit-jupiter-api")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")


    implementation("org.hsqldb:hsqldb:2.7.1")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.3")

}

tasks.test {
    useJUnitPlatform()
}
