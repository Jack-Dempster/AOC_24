import kotlin.math.abs

fun main() {
  fun part1(input: List<String>): Int {

    val (leftList, rightList) =
        input
            .associate { row ->
              val (left, right) = row.split("   ")
              left.toInt() to right.toInt()
            }
            .toList()
            .unzip()

    val leftSorted = leftList.sorted()
    val rightSorted = rightList.sorted()

    val sortedMap = leftSorted.zip(rightSorted)
    return sortedMap.fold(0) { acc, pair -> acc.plus(abs(pair.first.minus(pair.second))) }
  }

  fun part2(input: List<String>): Int {
    val (leftList, rightList) =
        input
            .associate { row ->
              val (left, right) = row.split("   ")
              left.toInt() to right.toInt()
            }
            .toList()
            .unzip()

    val leftSorted = leftList.sorted()
    val rightSorted = rightList.sorted()

    // Find all the unique numbers in either list
    // look through left list and sum
    // then right list and multiply
    val uniqueValues = leftSorted.toHashSet().sorted()
    return uniqueValues.fold(0) { acc, leftValue ->
      acc.plus(leftValue.times(rightSorted.filter { rightValue -> rightValue == leftValue }.size))
    }
  }

  val input = readInput("Day01_input")
  check(part1(input) == 1660292)

  check(part2(input) == 22776016)
}
