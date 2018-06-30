package ru.star

import java.nio.charset.{Charset, StandardCharsets}

import ru.star.Constants.WIKI_API_URL
import ru.star.config.{ConfigModel, ConfigWorker}
import ru.star.http.WikiClient
import scalaj.http.Http

object Main extends App {
  implicit val codec: Charset = StandardCharsets.UTF_8

  val startTime = System.currentTimeMillis()

  val config = initConfig()

  val client = new WikiClient(Http(WIKI_API_URL))

  println(client.getCategory("Политика"))
  println("----------------------------")
  println(client.getArticle("701840"))

  val endTime = System.currentTimeMillis
  println(s"Time taken: ${endTime - startTime} millis")

  def initConfig(): ConfigModel = {
    val configWorker = new ConfigWorker("app_config.json")
    ConfigModel(
      startCategories = Array("Политика", "Спорт"),
      crawlingThreadsCount = 1,
      queryDelay = 0,
      crawlingResultsPath = "",
      resultCsvName = "",
      printCount = 1
    )
  }
}
