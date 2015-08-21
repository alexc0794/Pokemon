name := "Pokemon"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.6.3" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.4" % "test",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scala-lang.modules" %% "scala-swing" % "1.0.1",
  "com.typesafe.play" %% "play-json" % "2.4.2"
)