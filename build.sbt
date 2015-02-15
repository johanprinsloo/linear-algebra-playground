name := "linalg playground"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies  ++= Seq(
            "org.scalanlp" %% "breeze" % "0.11-SNAPSHOT",
            "org.scalanlp" %% "breeze-natives" % "0.10",
            "org.scalanlp" %% "breeze-viz" % "0.11-SNAPSHOT",
            "org.jzy3d" % "jzy3d" % "0.9" from "http://www.jzy3d.org/release/0.9/org.jzy3d-0.9.jar"
)

addZipJar("org.jzy3d" % "jzy3d-deps" % "0.9.1" from "http://www.jzy3d.org/release/0.9/org.jzy3d-0.9-dependencies.zip", Compile)


resolvers ++= Seq(
            "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
            "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

initialCommands += """
  | import breeze.linalg._
  | import breeze.numerics._
  | import breeze.stats.distributions._
  | import breeze.plot._
  |	import java.io.File
  |""".stripMargin

cleanupCommands += """
  |println("Closing the SparkContext:")
  |""".stripMargin

addCommandAlias("etl", "runMain com.se.sqliteproc.etl.ingest")