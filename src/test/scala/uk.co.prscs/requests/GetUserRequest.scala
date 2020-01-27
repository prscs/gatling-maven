package uk.co.prscs.requests

import uk.co.prscs.config.Config.app_url
import uk.co.prscs.util.Environment._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetUserRequest {

  val get_user = exec(http("Get user Request")
    .get(apiURL + "/v1/employee/{id}")
    .header("Content-Type", "application/json")
    .check(status is 200))
}
