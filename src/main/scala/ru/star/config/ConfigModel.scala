package ru.star.config

case class ConfigModel(
  startCategories: Array[String],
  crawlingThreadsCount: Int,
  queryDelay: Int,
  crawlingResultsPath: String,
  resultCsvName: String,
  printCount: Int
)
