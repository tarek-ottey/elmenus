enablePlugins(JavaServerAppPackaging)

name := "elmenusHttp"

version := "1.0"

scalaVersion := "2.11.11"


resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io")

libraryDependencies ++= {
  val AkkaVersion       = "2.5.6"
  val SprayVersion      = "1.3.4"
  val Json4sVersion     = "3.2.11"
  Seq(
    "io.spray"          %% "spray-can"       % SprayVersion,
    "io.spray"          %% "spray-routing"   % SprayVersion,
    "com.typesafe.akka" %% "akka-slf4j"      % AkkaVersion,
    "ch.qos.logback"    %  "logback-classic" % "1.1.2",
    "org.json4s"        %% "json4s-native"   % Json4sVersion,
    "org.json4s"        %% "json4s-ext"      % Json4sVersion
  )
}

// Assembly settings
mainClass in Global := Some("com.elmenus.assignment.q5.Main")

jarName in assembly := "elmenus-http.jar"