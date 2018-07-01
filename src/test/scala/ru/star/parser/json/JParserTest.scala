package ru.star.parser.json

import org.scalatest.{FlatSpec, Matchers}
import ru.star.config.ConfigModel

class JParserTest extends FlatSpec with Matchers {
  behavior of "JParser"

  val parser = new TestParser

  it should "Parse json in case class with camel case fields" in {
    val json: String = "{\n  \"start_categories\": [\"Искусство\", \"Автомобили\", \"Бизнес\", \"Путешествия\", \"Религия\", \"Политика\", \"Наука\", \"Домашние животные\", \"Спорт\", \"Технология\"],\n  \"crawling_threads_count\": 5,\n  \"query_delay\": 0,\n  \"crawling_results_path\": \"/home/axreldable/IdeaProjects/wiki_scanner_java/crawling\",\n  \"result_csv_name\": \"/home/axreldable/IdeaProjects/wiki_scanner_java/crawling/result.csv\",\n  \"print_count\": 20\n}"

    val jsonConfig = parser.parseCamelCase[ConfigModel](json)

    val expected = ConfigModel(
      startCategories = Array("Искусство", "Автомобили", "Бизнес", "Путешествия", "Религия", "Политика", "Наука", "Домашние животные", "Спорт", "Технология"),
      crawlingThreadsCount = 5,
      queryDelay = 0,
      crawlingResultsPath = "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling",
      resultCsvName = "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling/result.csv",
      printCount = 20
    )

    // why it doesn't work?
//    jsonConfig shouldBe expected
    jsonConfig.startCategories shouldBe expected.startCategories
    jsonConfig.crawlingThreadsCount shouldBe expected.crawlingThreadsCount
    jsonConfig.queryDelay shouldBe expected.queryDelay
    jsonConfig.crawlingResultsPath shouldBe expected.crawlingResultsPath
    jsonConfig.resultCsvName shouldBe expected.resultCsvName
    jsonConfig.printCount shouldBe expected.printCount
  }
}
