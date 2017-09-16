name := """ScrambleGame"""
organization := "vn.inceptionlab"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += javaJpa
// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.9.Final"
libraryDependencies += "io.dropwizard.metrics" % "metrics-core" % "3.2.1"
libraryDependencies += "com.palominolabs.http" % "url-builder" % "1.1.0"
libraryDependencies += "net.jodah" % "failsafe" % "1.0.3"
libraryDependencies += "org.json" % "json" % "20170516"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "org.webjars" % "backbonejs" % "1.1.0"

libraryDependencies += "org.webjars" % "jquery" % "1.9.0"
libraryDependencies += "org.webjars" % "bootstrap" % "2.3.1"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
