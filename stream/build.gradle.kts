plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.amqp:spring-rabbit")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    runtimeOnly("com.h2database:h2:1.4.200")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
