package day04

import println
import readInputToLines

fun main() {

  val combinations = listOf("MSSM", "SMMS", "SSMM", "MMSS")
  fun part1(input: List<CharArray>): Int {
    var results = 0
    input.forEachIndexed { rowIndex, row ->
      row.forEachIndexed { charIndex, character ->
        if (character == 'X') {
          // check up
          if (rowIndex - 3 >= 0) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex - i][charIndex]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check down
          if (rowIndex + 3 < input.size) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex + i][charIndex]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check left
          if (charIndex - 3 >= 0) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex][charIndex - i]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check right
          if (charIndex + 3 < row.size) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex][charIndex + i]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check up left
          if (rowIndex - 3 >= 0 && charIndex - 3 >= 0) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex - i][charIndex - i]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check up right
          if (rowIndex - 3 >= 0 && charIndex + 3 < row.size) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex - i][charIndex + i]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check down left
          if (rowIndex + 3 < input.size && charIndex - 3 >= 0) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex + i][charIndex - i]
            if (charList.joinToString("") == "XMAS") results++
          }
          // check down right
          if (rowIndex + 3 < input.size && charIndex + 3 < row.size) {
            val charList = mutableListOf<Char>()
            for (i in (0..3)) charList += input[rowIndex + i][charIndex + i]
            if (charList.joinToString("") == "XMAS") results++
          }
        }
      }
    }
    results.println()
    return results
  }

  fun part2(input: List<CharArray>): Int {
    var results = 0
    input.forEachIndexed { rowIndex, row ->
      row.forEachIndexed { charIndex, character ->
        if (character == 'A') {
          val charList = mutableListOf<Char>()
          // check up left
          if (rowIndex - 1 >= 0 && charIndex - 1 >= 0)
              charList += input[rowIndex - 1][charIndex - 1]
          // check up right
          if (rowIndex - 1 >= 0 && charIndex + 1 < row.size)
              charList += input[rowIndex - 1][charIndex + 1]
          // check down right
          if (rowIndex + 1 < input.size && charIndex + 1 < row.size)
              charList += input[rowIndex + 1][charIndex + 1]
          // check down left
          if (rowIndex + 1 < input.size && charIndex - 1 >= 0)
              charList += input[rowIndex + 1][charIndex - 1]

          if (combinations.contains(charList.joinToString(""))) results++
        }
      }
    }
    results.println()
    return results
  }

  val testInput = readInputToLines("Day04_test").map { it.toCharArray() }
  check(part1(testInput) == 18)
  check(part2(testInput) == 9)

  val input = readInputToLines("Day04_input").map { it.toCharArray() }
  part1(input)
  part2(input)
}
