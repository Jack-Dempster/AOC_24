package day03

import allToInt
import readInput

fun main() {

  val digitRegex = "[0-9]{1,3},[0-9]{1,3}".toRegex()

  fun part1(input: String): Int {
    val regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)".toRegex()
    val validMuls = regex.findAll(input).map { it.value }.toList()
    return validMuls.fold(0) { acc, str ->
      val splitString = digitRegex.find(str)!!.value.split(",").allToInt()
      val (first, second) = splitString
      acc.plus(first.times(second))
    }
  }

  fun part2(input: String): Int {
    val regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)|(don't\\(\\)|do\\(\\))".toRegex()
    val validMuls = regex.findAll(input).map { it.value }.toList()
    var doMultiply = true
    return validMuls.fold(0) { acc, str ->
      if (str.contains("don't()")) doMultiply = false
      else if (str.contains("do()")) doMultiply = true
      if (doMultiply && !str.contains("do()")) {
        val splitString = digitRegex.find(str)!!.value.split(",").allToInt()
        val (first, second) = splitString
        acc.plus(first.times(second))
      } else acc
    }
  }

  val testInput = readInput("Day03_test")
  check(part1(testInput) == 161)

  val testPart2 = readInput("Day03_test_part2")
  check(part2(testPart2) == 48)

  val input = readInput("Day03_input")
  part2(input)
}
