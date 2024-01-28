pluginManagement {
	repositories {
		maven {
			name = "GTNH Maven"
			url = uri("http://jenkins.usrv.eu:8081/nexus/content/groups/public/")
			isAllowInsecureProtocol = true
			mavenContent {
				includeGroup("com.gtnewhorizons")
				includeGroup("com.gtnewhorizons.retrofuturagradle")
			}
		}
		maven {
			url = uri("https://maven.minecraftforge.net/")
		}
		maven {
			url = uri("https://maven.fabricmc.net")
		}
		maven {
			url = uri("https://repo.sleeping.town")
		}
		maven {
			url = uri("https://maven.neoforged.net/releases")
		}
		gradlePluginPortal()
		mavenCentral()
		mavenLocal()
	}
}

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include(":1.3.2")
include(":1.4.7")
include(":1.5.2")
include(":1.6.4")
include(":1.7.10")
include(":1.12.2")
include(":1.13.2")
include(":1.14.4")
include(":1.15.2")
include(":1.16.5")
include(":1.17.1")
include(":1.18.2")
include(":1.19.4")
include(":1.20.4")
include(":1.20.4-neo")
