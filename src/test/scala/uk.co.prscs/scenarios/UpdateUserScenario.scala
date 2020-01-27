package uk.co.prscs.scenarios

import uk.co.prscs.requests.UpdateUserRequest
import io.gatling.core.Predef.scenario

object UpdateUserScenario {

  val updateUserScenario = scenario("Update user scenario")
    .exec(UpdateUserRequest.update_user)

}
