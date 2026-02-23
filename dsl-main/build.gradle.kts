group = "io.github.promptmodeler"
version = "0.0.3"
description = "Prompt Modeler for Prompt used for AI Bots"

plugins {
  `java-library`
  alias(libs.plugins.mavencentral)
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(libs.junit.jupiter)
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  implementation(libs.guava)
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}

mavenPublishing {
  coordinates(group.toString(), name.toString(), version.toString())

  pom {
    name.set("Prompt Modeler")
    description.set("This is a prompt modeler which models prompts for bots")
    inceptionYear.set("2026")
    url.set("https://github.com/PromptModeler/prompt-modeler")
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }
    developers {
      developer {
        id.set("prompt-modeler")
        name.set("prompt-modeler")
        url.set("https://github.com/PromptModeler/prompt-modeler")
      }
    }
    scm {
      url.set("https://github.com/PromptModeler/prompt-modeler")
      connection.set("scm:git:git://github.com/PromptModeler/prompt-modeler")
      developerConnection.set("scm:git:ssh://git@github.com/PromptModeler/prompt-modeler")
    }
  }
}
