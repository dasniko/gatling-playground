package io.dasniko.gatling

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class RedisScenario extends Simulation {

  val csvFeeder = csv("rediskeys.csv").random

  val httpConf = http
    .baseURL("http://localhost:8080")
    .disableWarmUp

  val scn = scenario("BasicRedisSimulation")
    .feed(csvFeeder)
    .exec(
      http("redis_request")
      .post("/redis")
      .body(StringBody("""{"application":"${app}","uid":"${uid}"}"""))
      .asJSON
    )

  setUp(
    scn
      .inject(constantUsersPerSec(1000) during (10))
  )
    .protocols(httpConf)
    .assertions(
      global.responseTime.max.lessThan(50),
      global.successfulRequests.percent.greaterThan(95)
    )
}
