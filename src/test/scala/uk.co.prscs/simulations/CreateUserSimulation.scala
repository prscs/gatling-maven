package uk.co.prscs.simulations

import uk.co.prscs.config.Config._
import uk.co.prscs.scenarios.CreateUserScenario
import io.gatling.core.Predef._


class CreateUserSimulation extends Simulation {

  private val createUserExec = CreateUserScenario.createUserScenario
        .inject(atOnceUsers(users))

  setUp(createUserExec)

}
