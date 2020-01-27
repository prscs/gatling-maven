package uk.co.prscs.scenarios

import uk.co.prscs.requests.CreateUserRequest
import io.gatling.core.Predef.scenario

object CreateUserScenario {

  val createUserScenario = scenario("Create user scenario")
    .exec(CreateUserRequest.create_user)

}
