plugins {
	id("org.jetbrains.kotlin.jvm"       ) version "1.6.21"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.github.petercrawley"
version = "1.0.0"

repositories {
	mavenCentral() // Must be first
}

dependencies {

}

tasks {
	compileKotlin {
		targetCompatibility = "17"
	}

	shadowJar {
		archiveFileName.set("../$name-${archiveVersion}.jar")

		minimize()
	}

	build {
		dependsOn("shadowJar")
	}
}