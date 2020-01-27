package uk.co.prscs.scenarios

import uk.co.prscs.requests.DeleteUserRequest

import io.gatling.core.Predef.scenario


object DeleteUserScenario {

  val deleteUserScenario = scenario("Delete user scenario")
      .exec(DeleteUserRequest.delete_user)

}
