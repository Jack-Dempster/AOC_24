package day01

import kotlin.math.abs
import readInputToLines

fun main() {

  fun sortInput(input: List<String>): Pair<List<Int>, List<Int>> {
    val (leftList, rightList) =
        input
            .associate { row ->
              val (left, right) = row.split("   ")
              left.toInt() to right.toInt()
            }
            .toList()
            .unzip()

    return leftList.sorted() to rightList.sorted()
  }
  fun part1(input: List<String>): Int {
    val (left, right) = sortInput(input)
    val sortedMap = left.zip(right)

    return sortedMap.fold(0) { acc, pair -> acc.plus(abs(pair.first.minus(pair.second))) }
  }

  fun part2(input: List<String>): Int {
    val (left, right) = sortInput(input)

    // Find all the unique numbers in either list
    // look through left list and sum
    // then right list and multiply
    val uniqueValues = left.toHashSet().sorted()

    return uniqueValues.fold(0) { acc, leftValue ->
      acc.plus(leftValue.times(right.filter { rightValue -> rightValue == leftValue }.size))
    }
  }

  val input = readInputToLines("Day01_input")
  check(part1(input) == 1660292)

  check(part2(input) == 22776016)
}
