package ru.star.parser.json

import java.util

import org.scalatest.{FlatSpec, Matchers}
import ru.star.config.ConfigModel

class JParserSpec extends FlatSpec with Matchers {
  behavior of "JParser"

//  val parser = new TestParser
//
//  it should "Parse json in case class with camel case fields" in {
//    val json = """{
//                 |  "start_categories": ["Искусство", "Автомобили", "Бизнес", "Путешествия", "Религия", "Политика", "Наука", "Домашние животные", "Спорт", "Технология"],
//                 |  "crawling_threads_count": 5,
//                 |  "query_delay": 0,
//                 |  "crawling_results_path": "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling",
//                 |  "result_csv_name": "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling/result.csv",
//                 |  "print_count": 20
//                 |}"""
//
//    val jsonConfig = parser.parseCamelCase[ConfigModel](json)
//
//    jsonConfig shouldBe ConfigModel(
//      startCategories = Array("Искусство", "Автомобили", "Бизнес", "Путешествия", "Религия", "Политика", "Наука", "Домашние животные", "Спорт", "Технология"),
//      crawlingThreadsCount = 5,
//      queryDelay = 0,
//      crawlingResultsPath = "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling",
//      resultCsvName = "/home/axreldable/IdeaProjects/wiki_scanner_java/crawling/result.csv",
//      printCount = 20
//    )
//  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new util.Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}
