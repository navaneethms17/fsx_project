package computerdatabase

import scala.concurrent.duration._

import java.util.concurrent.ThreadLocalRandom

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ComputerWorld extends Simulation {

  val httpProtocol = http
    .baseUrl("https://fsx-qa.pragiti.com")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36")


  val headers_10 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")


  val scn = scenario("homepage")
    .exec(http("request_10")
      .get("/fsxstorefront/fsx/en_US/")
      .headers(headers_10))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}