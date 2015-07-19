package io.dasniko.gatling

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
object Engine extends App {

  val props = new GatlingPropertiesBuilder
  props.dataDirectory(IDEPathHelper.dataDirectory.toString())
  props.resultsDirectory(IDEPathHelper.resultsDirectory.toString())
  props.bodiesDirectory(IDEPathHelper.requestBodiesDirectory.toString())
  props.binariesDirectory(IDEPathHelper.binariesDirectory.toString())
  props.simulationClass(classOf[RedisScenario].getName)

  Gatling.fromMap(props.build)

}
