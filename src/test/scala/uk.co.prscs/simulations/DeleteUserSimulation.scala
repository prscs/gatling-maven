package uk.co.prscs.simulations

import uk.co.prscs.config.Config._
import uk.co.prscs.scenarios.DeleteUserScenario
import io.gatling.core.Predef._

class DeleteUserSimulation extends Simulation{

  private val deleteUserExec = DeleteUserScenario.deleteUserScenario
    .inject(atOnceUsers(users))

  setUp(deleteUserExec)
}
