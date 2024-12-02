package day1

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int = input.buildLists().let { (leftIds, rightIds) ->
        leftIds.sorted().zip(rightIds.sorted())
            .sumOf { (leftId, rightId) -> abs(leftId - rightId) }
    }

    fun part2(input: List<String>): Int = input.buildLists().let { (leftIds, rightIds) ->
        leftIds.sumOf { id -> id * rightIds.count { it == id } }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

private fun List<String>.buildLists(): Pair<List<Int>, List<Int>> = map { line ->
    with(line.split(Regex("\\s+"))) {
        first().toInt() to last().toInt()
    }
}.unzip()
