ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

libraryDependencies += "com.slack.api" % "bolt" % "1.31.0"
libraryDependencies += "com.slack.api" % "bolt-socket-mode" % "1.31.0"
libraryDependencies += "javax.websocket" % "javax.websocket-api" % "1.1"
libraryDependencies += "org.glassfish.tyrus.bundles" % "tyrus-standalone-client" % "1.19"

lazy val root = (project in file("."))
  .settings(
    name := "slack-labor"
  )
