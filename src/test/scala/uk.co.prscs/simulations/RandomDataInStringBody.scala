package uk.co.prscs.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

class RandomDataInStringBody extends Simulation {

  object randomStringGenerator {
    def randomString(length: Int) = scala.util.Random.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  val req = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<gpOBJECT>\n" +
    "<gpPARAM name=\"auth_method\">3</gpPARAM>\n" +
    "<gpPARAM name=\"app_url\">MY_APP</gpPARAM>\n" +
    "<gpPARAM name=\"log_session_id\">0000000000</gpPARAM>\n" +
    "<gpPARAM name=\"device_id\">b02edd23,ClientIP=10.211.55.3</gpPARAM>\n" +
    "<gpPARAM name=\"service\">ACTIVATION</gpPARAM>\n" +
    "</gpOBJECT>"

  var randomSession = Iterator.continually(Map("randsession" -> ( req.replace("0000000000", randomStringGenerator.randomString(10)))))

  val httpConf = http
    .baseURL("http://localhost:5000")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .userAgentHeader("Mozilla/4.0(compatible;IE;GACv10. 0. 0. 1)")

  val scn = scenario("Activate")
    .feed(randomSession)
    .exec(http("activate request")
      .post("/login/activate")
      .body(StringBody("""${randsession}"""))
      .check(status.is(200)))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(5))
  ).protocols(httpConf)
}