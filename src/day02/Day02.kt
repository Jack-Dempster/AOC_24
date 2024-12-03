package day02

import allToInt
import println
import readInputToLines
import toInt

fun main() {

  fun isSafe(row: List<Int>): Boolean {
    val differences = row.windowed(2).map { it[1] - it[0] }
    return differences.all { it in 1..3 } || differences.all { it < 0 && it >= -3 }
  }

  fun part1(input: List<List<Int>>): Int {
    return input.map { it }.count(::isSafe)
  }

  fun part2(input: List<List<Int>>): Int {
    return input
        .map { it }
        .count {
          isSafe(it) || (0..it.size).any { index -> isSafe(it.take(index) + it.drop(index + 1)) }
        }
  }

  val testInput = readInputToLines("Day02_test").map { row -> row.split(" ").allToInt() }
  check(part1(testInput) == 2)
  check(part2(testInput) == 4)

  val edgeCaseInput =
      readInputToLines("Day02_edge").map { row -> row.split(" ").map { it.toInt() } }
  check(part2(edgeCaseInput) == 2)

  val input = readInputToLines("Day02_input").map { row -> row.split(" ").allToInt() }
  part1(input).println()
  check(part1(input) == 686)
  part2(input).println()
  check(part2(input) == 717)
}
