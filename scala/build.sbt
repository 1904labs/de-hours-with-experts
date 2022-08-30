ThisBuild / scalaVersion := "3.1.3"
ThisBuild / organization := "com.labs1904"

lazy val hoursWithExperts = (project in file("."))
  .settings(
    name := "hoursWithExperts",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13" % Test,
  )
