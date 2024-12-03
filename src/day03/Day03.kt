package day03

import println
import readInput

fun main() {

  fun part1(input: String): Int {
    val regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)".toRegex()
    val digitRegex = "[0-9]{1,3},[0-9]{1,3}".toRegex()
    val validMuls = regex.findAll(input).map { it.value }.toList()
    val result =
        validMuls.fold(0) { acc, str ->
          val splitString = digitRegex.find(str)!!.value.split(",")
          val exprs = splitString[0].toInt().times(splitString[1].toInt())
          acc.plus(exprs)
        }
    result.println()
    return result
  }

  fun part2(input: String): Int {
    val regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)|(don't\\(\\)|do\\(\\))".toRegex()
    val digitRegex = "[0-9]{1,3},[0-9]{1,3}".toRegex()
    val validMuls = regex.findAll(input).map { it.value }.toList()
    var doMultiply = true
    val result =
        validMuls.fold(0) { acc, str ->
          if (str.contains("don't()")) doMultiply = false
          else if (str.contains("do()")) doMultiply = true
          if (doMultiply && !str.contains("do()")) {
            val splitString = digitRegex.find(str)!!.value.split(",")
            val exprs = splitString[0].toInt().times(splitString[1].toInt())
            acc.plus(exprs)
          } else acc
        }
    result.println()
    return result
  }

  val testInput = readInput("Day03_test")
  check(part1(testInput) == 161)

  val testPart2 = readInput("Day03_test_part2")
  check(part2(testPart2) == 48)

  val input = readInput("Day03_input")
  part2(input)
}
