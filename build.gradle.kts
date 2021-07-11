import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
    kotlin("plugin.jpa") version "1.5.10"
}

group = "com.buta"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.mariadb.jdbc:mariadb-java-client")


    // kotlin에서 클래스는 기본 final이기 때문에 JPA에서 지연로딩시 entity를 상속받아 처리하는 proxy를 이용할 수 없다.
    // 즉, 지연로딩을 할 수 없다. 이를 해결해주는 컴파일러 플러그인이다. 모든 entity를 open시켜준다.
    implementation("org.jetbrains.kotlin:kotlin-allopen:$embeddedKotlinVersion")
    // JPA entity들은 기본적으로 기본생성자가 필요하다. 하지만 주 생성자가 존재하면 기본생성자가 없다.
    // @Entity가 붙은 클래스들에 한해서 자동으로 인자없는 생성자를 추가해준다.
    implementation("org.jetbrains.kotlin:kotlin-noarg:$embeddedKotlinVersion")

    // Swagger
    implementation("io.springfox:springfox-swagger2:2.8.0")
    implementation("io.springfox:springfox-swagger-ui:2.8.0")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
