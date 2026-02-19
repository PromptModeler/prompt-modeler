plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "PromptModeler1"
include("dsl-main")


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")