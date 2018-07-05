package ru.star.config

import ru.star.parser.json.JParser
import scalax.file.Path

import scala.io.Source

class ConfigWorker(private val configPath: String) extends JParser {
  private val configJson: String = Source.fromFile(configPath).getLines().mkString

  val config: ConfigModel = parseCamelCase[ConfigModel](configJson)
  validate(config)

  /**
    * Method for validate the configuration.
    *
    * @throws IllegalArgumentException throws when the config is wrong
    */
  private def validate(config: ConfigModel): Unit = {
    require(config.startCategories.length > 0, "At least one starting category is required")
    require(config.crawlingThreadsCount > 0, "At least one crawling thread is required")
    require(config.queryDelay >= 0, "queryDelay should not be negative")
    require(config.printCount > 0, "At least one article for printing is required")

    require(config.crawlingResultsPath.length != 0, "crawlingResultsPath shouldn't be empty")
    require(config.resultCsvName.length != 0, "getResultCsvName shouldn't be empty")
  }

  /**
    * Creates directories for crawling results if need it.
    */
  def createCrawlingResultPath(): Unit = Path(config.crawlingResultsPath).createDirectory(failIfExists = false)

  /**
    * Create or rewrite crawling results file.
    */
  def createOrRewriteResultFile(): Unit = Path(config.resultCsvName).createFile(createParents = true, failIfExists = false)
}
