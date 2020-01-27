package uk.co.prscs.config

object Config {
  val app_url = "http://dummy.restapiexample.com/api"

  val users = Integer.getInteger("users", 10).toInt
  val rampUp = Integer.getInteger("rampup", 1).toInt
  val throughput = Integer.getInteger("throughput", 100).toInt
}
