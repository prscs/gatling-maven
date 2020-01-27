package uk.co.prscs.requests

import uk.co.prscs.util.Environment._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateUserRequest {


  val create_user = exec(http("Create user request")
    .post(apiURL + "/v1/create")
    .body(StringBody("""{"name":"shravanteshhsts123!","salary":"123456789","age":"23"}"""))
    .asJSON
    .headers(Map("Content-Type" -> "application/json"))
    .check(status is 200)
    .check(jsonPath("$.id").saveAs("id")))


    .exec {
      session =>
        println("Session: " + session)
        session
    }
}
