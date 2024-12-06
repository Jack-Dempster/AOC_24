package day05

import readInput

fun String.inputToRulesAndNumbers(): Pair<List<Pair<String, String>>, List<List<String>>> {
  val (pageRules, pageNumbers) = this.split("\n\n")
  val rulesPairs = pageRules.split("\n").map { it.split("|").zipWithNext().single() }
  val updates = pageNumbers.split("\n").map { it.split(",") }

  return rulesPairs to updates
}

fun checkValidUpdateRow(rules: List<Pair<String, String>>, updates: List<List<String>>) {
  val validRows = mutableListOf<List<String>>()
  updates.forEach { row ->
    val updatePairsForRow = row.map { update -> row[0] to update }
    val rowIsValid = listOf<Boolean>()
    if (row.map { updatePairsForRow.contains(row[0] to it) }.all { true }) validRows.add(row)
  }
}

fun main() {

  fun part1(input: Pair<List<Pair<String, String>>, List<List<String>>>): Int {
    /**
     * for each update identify possible correct rows by looking at first number to all other
     * entries and checking the pairs exist for that update.
     */
    val (rules, updates) = input
    checkValidUpdateRow(rules, updates)
    return 5
  }

  fun part2(input: String) {}

  val testInput = readInput("Day05_test").inputToRulesAndNumbers()
  check(part1(testInput) == 143)

  //  val input = readInput("Day04_input")
}
