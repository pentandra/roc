/*
 * Copyright 2013 Pentandra Research Solutions, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._
import Keys._

import sbtunidoc.Plugin._
import sbtunidoc.Plugin.UnidocKeys._

object Version {
  val Scala = "2.10.1"
  val Akka = "2.1.2"
  val ScalaTest = "1.9.1"
}

object Compiler {
  val defaultSettings = Seq(
    scalacOptions in Compile ++= Seq("-target:jvm-1.7", "-unchecked", "-feature", "-language:postfixOps", "-language:implicitConversions"),
    javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")
  )
}

object Publish {
  val parentSettings = Seq(
    publishArtifact in Compile := false
  )
}

object Tests {
  val defaultSettings = Seq(
    parallelExecution in Test := false
  )
}

object RocBuild extends Build {

  lazy val defaultSettings =
    Defaults.defaultSettings ++
    Compiler.defaultSettings ++
    Tests.defaultSettings

  lazy val unidocExcludeSettings = Seq(
    excludedProjects in unidoc in ScalaUnidoc ++= Seq(rocCoreTest.id)
  )

  lazy val unidocDefaultSettings = scalaJavaUnidocSettings ++ unidocExcludeSettings

  lazy val roc = Project(
    id = "roc",
    base = file("."),
    settings = defaultSettings ++ unidocDefaultSettings ++ Publish.parentSettings
  ) aggregate(rocCore, rocCoreTest)

  lazy val rocCore = Project(
    id = "roc-core",
    base = file("roc-core"),
    settings = defaultSettings
  )

  lazy val rocCoreTest = Project(
    id = "roc-core-test",
    base = file("roc-core-test"),
    settings = defaultSettings
  ) dependsOn(rocCore)

}
