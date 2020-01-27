package uk.co.prscs.requests

import uk.co.prscs.config.Config._
import uk.co.prscs.util.Environment._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteUserRequest {

  val delete_user = exec(http("Delete user request")
    .delete(apiURL + "/v1/delete/{id}")
    .check(regex("successfully! deleted Records").exists)
    .check(status is 200))

}
