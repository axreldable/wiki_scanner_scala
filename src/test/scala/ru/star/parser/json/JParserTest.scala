package ru.star.parser.json

import org.scalatest.{FlatSpec, Matchers}
import ru.star.config.ConfigModel

class JParserTest extends FlatSpec with Matchers {
  behavior of "JParser"

  val parser = new TestParser

  it should "Parse json in case class with camel case fields" in {
    val json: String = """{
                         |  "start_categories": ["Искусство"],
                         |  "crawling_threads_count": 5,
                         |  "query_delay": 0,
                         |  "crawling_results_path": "path_to_dir",
                         |  "result_csv_name": "path_to_csv",
                         |  "print_count": 20
                         |}""".stripMargin

    val jsonConfig = parser.parseCamelCase[ConfigModel](json)

    val expected = ConfigModel(
      startCategories = Array("Искусство"),
      crawlingThreadsCount = 5,
      queryDelay = 0,
      crawlingResultsPath = "path_to_dir",
      resultCsvName = "path_to_csv",
      printCount = 20
    )

    jsonConfig.startCategories shouldBe expected.startCategories
    jsonConfig.crawlingThreadsCount shouldBe expected.crawlingThreadsCount
    jsonConfig.queryDelay shouldBe expected.queryDelay
    jsonConfig.crawlingResultsPath shouldBe expected.crawlingResultsPath
    jsonConfig.resultCsvName shouldBe expected.resultCsvName
    jsonConfig.printCount shouldBe expected.printCount
  }
}
