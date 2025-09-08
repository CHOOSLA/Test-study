plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.5.5")
    implementation("org.springframework:spring-beans:6.2.9")
    testImplementation("org.mockito:mockito-junit-jupiter:5.19.0")
    testImplementation("org.assertj:assertj-core:3.27.4")
    testImplementation("org.mockito:mockito-core:5.19.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}