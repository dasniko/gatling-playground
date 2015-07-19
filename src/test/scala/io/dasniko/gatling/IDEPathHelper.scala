package io.dasniko.gatling

import scala.reflect.io.File

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
object IDEPathHelper {

  val gatlingConfUrl = getClass.getClassLoader.getResource("gatling.conf").getPath
  val projectRootDir = File(gatlingConfUrl).parents(3)

  val resourcesDirectory = projectRootDir / "src" / "test" / "resources"
  val targetDirectory = projectRootDir / "target" / "scala-2.11"
  val binariesDirectory = targetDirectory / "test-classes"
  val dataDirectory = resourcesDirectory / "data"
  val requestBodiesDirectory = resourcesDirectory / "request-bodies"
  val resultsDirectory = targetDirectory / "results"

}
