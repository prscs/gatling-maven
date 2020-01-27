package uk.co.prscs.requests

import uk.co.prscs.config.Config.app_url
import uk.co.prscs.util.Environment._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object UpdateUserRequest {

  val update_user = exec(http("Update user request")
      .put(apiURL + "/v1/update/{id}")
      .header("Content-Type", "application/json")
      .header("Accept", "application/json")
      .body(StringBody("""{"name":"testhdhhdhgd!!!1","salary":"1123","age":"23"}"""))
      .asJSON
      .check(status is 200))

}
